package basic.annotation.demo2;

import java.lang.annotation.*;
/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName Constraints
 * @date 2020/1/8 11:57
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Constraints {
    boolean primaryKey() default false;
    boolean allowNull() default true;
    boolean unique() default false;
}
