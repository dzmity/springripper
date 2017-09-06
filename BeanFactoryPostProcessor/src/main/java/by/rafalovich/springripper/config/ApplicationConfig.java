package by.rafalovich.springripper.config;

import by.rafalovich.springripper.entity.Quoter;
import by.rafalovich.springripper.entity.impl.Shakespeare;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.List;

import static java.util.Arrays.asList;

@Configuration
@ComponentScan("by.rafalovich.springripper")
public class ApplicationConfig
{
    @Bean
    public List<String> terminatorQuotes()
    {
        return asList(
                "I'll be back",
                "Hasta la vista, babby.",
                "I need your clothes.");
    }

    @Bean
    @Scope("prototype")
    public Quoter shakespeareQuoter()
    {
        return new Shakespeare();
    }
}
