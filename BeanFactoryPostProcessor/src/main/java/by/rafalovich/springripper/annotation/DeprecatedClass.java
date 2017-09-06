package by.rafalovich.springripper.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * A class annotated &#64;Deprecated is one that programmers
 * are discouraged from using, typically because a better alternative exists.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DeprecatedClass
{
    /**
     * The newClass indicate new instances of the class {@code Class}, that should replaced
     * a class annotated &#64;Deprecated.
     *
     * @return the suggested component class.
     */
    Class newClass();
}
