package com.example.Firstproject.controller;

import com.example.Firstproject.DTO.ArticleForm;
import com.example.Firstproject.DTO.CommentDto;
import com.example.Firstproject.Repository.ArticleRepository;
import com.example.Firstproject.entity.Article;
import com.example.Firstproject.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j
public class ArticleController  {
    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CommentService commentService;
    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }
    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
       // System.out.println(form.toString());
        log.info(form.toString());
        Article article = form.toEntity();
        //System.out.println(article.toString());
        log.info(article.toString());

        Article saved = articleRepository.save(article);
        //System.out.println(saved.toString());
        log.info(article.toString());
        return "redirect:/articles/"+saved.getId();
    }
    //DTO변환

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model){
        Article article = articleRepository.findById(id).orElse(null);
        List <CommentDto> commentDtoss = commentService.comments(id);

        model.addAttribute("commentDtos",commentDtoss);
        model.addAttribute("article",article);
        log.info("id = "+id);
        //id를 가져오고, model에 연결후 , 보여줄 페이지를 설정해야함
    return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model){
        List<Article> articleList = articleRepository.findAll();

        model.addAttribute("articleList",articleList);
        return "articles/index";
    }

    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        Article articleEntity = articleRepository.findById(id).orElse(null);
        model.addAttribute("article",articleEntity);

        return "articles/edit";
    }
    @PostMapping("/articles/update")
    public String update(ArticleForm form){
        log.info(form.toString());
        //DTO를 엔티티로 변환
        Article articleEn = form.toEntity();
        //DB에서 정보 가져와서 수정
        Article target = articleRepository.findById(articleEn.getId()).orElse(null);

        if(target !=null){
            articleRepository.save(articleEn);
        }
        return "redirect:/articles/"+articleEn.getId();
    }

    @GetMapping("/articles/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr) {
        log.info("삭제 요청이 들어왔습니다!!");

        // 1: 삭제 대상을 가져옴
        Article target = articleRepository.findById(id).orElse(null);
        log.info(target.toString());

        // 2: 대상을 삭제
        if (target != null) {
            articleRepository.delete(target);
            rttr.addFlashAttribute("msg", "삭제가 완료되었습니다.");
        }

        // 3: 결과 페이지로 리다이렉트
        return "redirect:/articles";
    }


}
