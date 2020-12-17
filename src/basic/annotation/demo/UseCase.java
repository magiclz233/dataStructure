package basic.annotation.demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName UseCase
 * @date 2020/1/8 11:19
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface UseCase {
    int id();
    String description() default "no description";
}
