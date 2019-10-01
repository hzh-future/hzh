package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-mvc.xml");
//        LoginHandler handler = (LoginHandler)context.getBean("loginHandler");
        System.out.println("输出");
     }
}
