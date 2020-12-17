package basic.annotation.demo2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName SqlInteger
 * @date 2020/1/8 12:18
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SqlInteger {
    String name() default "";
    /*
     @Constraints 注解允许处理器提供数据库表的元数据。
     @Constraints 代表了数据库通常提供的约束的一小部分，
     但是它所要表达的思想已经很清楚了。`primaryKey()`，`allowNull()` 和 `unique()`
     元素明显的提供了默认值，从而使得在大多数情况下，该注解的使用者不需要输入太多东西。
     */
    Constraints constraints() default @Constraints;
}
