package basic.reflect.reflect.reflect1;

import basic.reflect.reflect.reflect1.annotation.MyAnnotation;
import basic.reflect.reflect.reflect1.annotation.MyAnnotationField;
import basic.reflect.reflect.reflect1.annotation.MyAnnotationMethod;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author magic_lz
 * @version 1.0
 * @date 2020/3/3 22:48
 */
@MyAnnotation(name = "test", value = "magicLz233")
public class GetAnnotationTest {

    @MyAnnotationField(name = "123", value = "magic")
    private String name;

    @MyAnnotationMethod(name = "method", value = "Method Annotation Test")
    public void annotationTest() {
        System.out.println("Method Annotation Test");
    }

    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {
        System.out.println("获取所有类注解");
        Annotation[] annotations = GetAnnotationTest.class.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof MyAnnotation) {
                MyAnnotation myAnnotation = (MyAnnotation) annotation;
                System.out.println("MyAnnotation name: " + myAnnotation.name());
                System.out.println("MyAnnotation value: " + myAnnotation.value());
            }
        }
        System.out.println("直接获取类注解");
        MyAnnotation annotation = GetAnnotationTest.class.getAnnotation(MyAnnotation.class);
        System.out.println("MyAnnotation name: " + annotation.name());
        System.out.println("MyAnnotation value: " + annotation.value());

        System.out.println("获取所有方法注解");
        Method annotationTest = GetAnnotationTest.class.getMethod("annotationTest");
        Annotation[] annotations1 = annotationTest.getAnnotations();
        for (Annotation annotation1 : annotations1) {
            if(annotation1 instanceof MyAnnotationMethod){
                MyAnnotationMethod methodAnnotation = (MyAnnotationMethod) annotation1;
                System.out.println(methodAnnotation.name()+"~~"+methodAnnotation.value());
            }
        }

        System.out.println("获取属性注解");
        Field name = GetAnnotationTest.class.getDeclaredField("name");
        MyAnnotationField annotationField = name.getAnnotation(MyAnnotationField.class);
        System.out.println(annotationField.name()+ "~~~" + annotationField.value());
    }
}
