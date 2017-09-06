package by.rafalovich.springripper.bean_factory_post_processor;

import by.rafalovich.springripper.annotation.DeprecatedClass;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@code BeanFactoryPostProcessor} that replace classes of components,
 * annotated with {@link DeprecatedClass} annotation.
 */
@Component
public class DeprecatedClassReplacer implements BeanFactoryPostProcessor
{
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException
    {
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames)
        {
            AbstractBeanDefinition beanDefinition = (AbstractBeanDefinition) beanFactory.getBeanDefinition(beanName);
            String beanClassName = beanDefinition.getBeanClassName();

            /**
             * beanClassName could be null if component, annotated with {@link DeprecatedClass} annotation,
             * has bean definition in one of {@link Configuration} classes.
             */
            if (beanClassName != null)
            {
                try
                {
                    Class<?> originalClass = Class.forName(beanClassName);
                    DeprecatedClass annotation = originalClass.getAnnotation(DeprecatedClass.class);
                    if (annotation != null)
                    {
                        beanDefinition.setBeanClass(annotation.newClass());
                    }

                }
                catch (ClassNotFoundException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
