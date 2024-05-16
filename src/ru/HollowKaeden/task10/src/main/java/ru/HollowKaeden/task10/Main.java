package ru.HollowKaeden.task10;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Junior junior = context.getBean(Junior.class);
        Middle middle = context.getBean(Middle.class);
        Senior senior = context.getBean(Senior.class);
        junior.doCoding();
        middle.doCoding();
        senior.doCoding();
        context.close();
    }
}
