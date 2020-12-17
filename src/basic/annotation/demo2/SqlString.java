package basic.annotation.demo2;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName SqlString
 * @date 2020/1/8 12:14
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SqlString {
    int value() default 0;
    String name() default "";
    Constraints constraints() default @Constraints;

}
