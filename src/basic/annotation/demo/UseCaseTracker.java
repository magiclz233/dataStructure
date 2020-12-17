package basic.annotation.demo;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName UseCaseTracker
 * @date 2020/1/8 11:29
 */
public class UseCaseTracker {

    /**
     * @param useCases List
     * @param cl Class
     */
    public static void trackUseCases(List<Integer> useCases,Class<?> cl){

        /*
         *   getDeclaredMethods
         * 返回一个包含{@code Method}对象的数组，这些对象反映了所有
         * 此{@code代表的类或接口的声明方Class}对象，包括public，protected，default（包）
         * 访问和私有方法，但不包括继承的方法。
         */
        for (Method method:cl.getDeclaredMethods()){
            UseCase useCase = method.getAnnotation(UseCase.class);
            if(useCase != null){
                System.out.println("UseCase:id="+useCase.id()+",description="+useCase.description());
                useCases.remove(Integer.valueOf(useCase.id()));
            }
        }
        useCases.forEach(i -> System.out.println("Missing UseCase:"+i));
    }

    public static void main(String[] args){
        List<Integer> collect = IntStream.range(47, 51).boxed().collect(Collectors.toList());
        trackUseCases(collect,PasswordUtils.class);
    }
}
