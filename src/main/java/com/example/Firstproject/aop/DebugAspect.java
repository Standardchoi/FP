package com.example.Firstproject.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect //AOPŬ���� ���� �ΰ���� ���� Ŭ����
@Component //IOC�����̳ʿ� �� ���
@Slf4j
public class DebugAspect {
    //��� �޼ҵ� ����
    @Pointcut("execution(* com.example.Firstproject.service.CommentService.*(..))")
    private void cut(){

    }
    //cut���� �Լ��� ����Ǳ� ���� ����ȴ�.
    @Before("cut()")
    public void logging(JoinPoint joinPoint){
        // �Է°� ��������
        Object[] args = joinPoint.getArgs();

        // Ŭ������
        String className = joinPoint.getTarget()
                .getClass()
                .getSimpleName();

        // �޼ҵ��
        String methodName = joinPoint.getSignature()
                .getName();

        // �Է°� �α��ϱ�
        for (Object obj : args) {
            log.info("{}#{}�� �Է°� => {}", className, methodName, obj);
        }

    }

    @AfterReturning(value = "cut()", returning = "returnObj")
    public void loggingReturnValue(JoinPoint joinPoint,
                                   Object returnObj) {
        // Ŭ������
        String className = joinPoint.getTarget()
                .getClass()
                .getSimpleName();

        // �޼ҵ��
        String methodName = joinPoint.getSignature()
                .getName();

        // ��ȯ�� �α�
        log.info("{}#{}�� ��ȯ�� => {}", className, methodName, returnObj);

    }

}
