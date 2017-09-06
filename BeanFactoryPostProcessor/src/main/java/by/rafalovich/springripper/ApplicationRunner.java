package by.rafalovich.springripper;

import by.rafalovich.springripper.config.ApplicationConfig;
import by.rafalovich.springripper.entity.impl.Terminator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:application.properties")
public class ApplicationRunner
{
    public static void main(String[] args)
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Terminator terminator = (Terminator) context.getBean("terminator");
        terminator.sayQuote();
    }
}
