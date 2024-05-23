package ru.HollowKaeden.task21;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {
    @Before("allServiceMethods()")
    public void logParameters(JoinPoint joinPoint) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.info(formatter.format(date));
    }
    @Pointcut("within(ru.HollowKaeden.task21.service.*)")
    public void allServiceMethods() {}
}