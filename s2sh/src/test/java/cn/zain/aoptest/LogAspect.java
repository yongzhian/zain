package cn.zain.aoptest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
@Aspect  //声明切面
@Component //切面由spring管理
public class LogAspect {
    private static Logger  logger = LogManager.getLogger(LogAspect.class);
    //定义切点 注解为action的方法为需要切的点
    @Pointcut("@annotation(cn.zain.aoptest.Action)")  //通过注解精确指定切入点 只能是方法
    public void annotationPointCut(){};

    @After("annotationPointCut()")
    public void afterByAnnotation(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action=method.getAnnotation(Action.class);
        logger.info("注解拦截，哈哈," + action.name());
    }


    @Before("execution(* cn.zain.aoptest.DemoMethodService.*(..))")  //表达式指定切面范围
    public void afterByMethod(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        logger.info("方法拦截 貌似简单，哈哈," + method.getName());
    }

}
