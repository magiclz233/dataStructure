package basic.annotation.demo2;

/**
 * @author magic_lz
 * Description TODO 嵌套注释的样本
 * @version 1.0
 * @ClassName Uniqueness
 * @date 2020/1/8 12:22
 */
public @interface Uniqueness {
    Constraints CONSTRAINTS() default @Constraints(unique = true);
}
