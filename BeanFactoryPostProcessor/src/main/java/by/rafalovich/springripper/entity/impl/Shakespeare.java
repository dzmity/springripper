package by.rafalovich.springripper.entity.impl;

import by.rafalovich.springripper.entity.Quoter;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PreDestroy;

public class Shakespeare implements Quoter
{
    @Value("shakespeare.quot")
    private String quote;

    public void sayQuote()
    {
        System.out.println(quote);
    }

    @PreDestroy
    public void destroyShakespeare()
    {
        System.out.println("Destroy Shakespeare method.");
    }
}
