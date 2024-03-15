package com.example.Firstproject.DTO;

import com.example.Firstproject.entity.Comment;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@Getter
@ToString
@NoArgsConstructor
public class CommentDto {
    private Long id;

    @JsonProperty("article_id")
    private Long articleId;

    private String nickname;

    private String body;

    public static CommentDto createCommentDto(Comment comment) {
        return new CommentDto(
                comment.getId(),
                comment.getArticle().getId(),
                comment.getNickname(),
                comment.getBody()
        );
    }
}
