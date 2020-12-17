package basic.annotation;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName Test
 * @date 2020/1/7 17:31
 */
public class Test {
    public static void main(String[] args){
        Class<AnnoDemo> annoDemoClass = AnnoDemo.class;
        boolean annotation = annoDemoClass.isAnnotation();
        System.out.println(annotation);
        Demo annotation1 = annoDemoClass.getAnnotation(Demo.class);
        String name = annotation1.name();
        String value = annotation1.value();
        System.out.println(name);
        System.out.println(value);
    }
}
