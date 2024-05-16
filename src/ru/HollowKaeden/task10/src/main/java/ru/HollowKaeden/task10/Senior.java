package ru.HollowKaeden.task10;

import org.springframework.stereotype.Component;

@Component
public class Senior implements Programmer {
    @Override
    public void doCoding() {
        System.out.println("Senior programmer is working...");
    }
}