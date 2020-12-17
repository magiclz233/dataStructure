package basic.annotation.demo2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName DBTable
 * @date 2020/1/8 11:53
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DBTable {
    String name() default "";
    
}
