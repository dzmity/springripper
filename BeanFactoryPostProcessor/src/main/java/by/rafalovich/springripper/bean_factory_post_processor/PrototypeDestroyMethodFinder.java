package by.rafalovich.springripper.bean_factory_post_processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@code BeanFactoryPostProcessor} that informs in console output
 * if component with {@link Scope} prototype has destroy method, because this method never be invoke.
 */
@Component
public class PrototypeDestroyMethodFinder implements BeanFactoryPostProcessor
{
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException
    {
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames)
        {
            AbstractBeanDefinition beanDefinition = (AbstractBeanDefinition) beanFactory.getBeanDefinition(beanName);
            if (beanDefinition.isPrototype() && beanDefinition.getDestroyMethodName() != null)
            {
                System.out.println(
                        "Bean with name " + beanName + " has scope prototype. Destroy method " + beanDefinition
                                .getDestroyMethodName() + " will not be work.");
            }
        }

    }
}
