package by.rafalovich.springripper.entity.impl;

import by.rafalovich.springripper.annotation.DeprecatedClass;
import by.rafalovich.springripper.entity.Quoter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("terminator")
@DeprecatedClass(newClass = T1000.class)
public class Terminator implements Quoter
{
    @Autowired
    @Qualifier("terminatorQuotes")
    private List<String> terminatorQuotes;

    public void sayQuote()
    {
        for (String quote : terminatorQuotes)
        {
            System.out.println(quote);
        }
    }
}
