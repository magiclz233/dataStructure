package basic.equals;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName EqualityFactory
 * @date 2020/1/9 11:34
 */
public interface EqualityFactory {
    Equality make(int i, String s, double d);
}
