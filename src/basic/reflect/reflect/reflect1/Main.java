package basic.reflect.reflect.reflect1;

import java.lang.reflect.Array;

/**
 * @author magic_lz
 * @version 1.0
 * @date 2020/3/2 21:11
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = (int[]) Array.newInstance(int.class, 3);
        Array.set(arr,0,1);
        Array.set(arr,1,2);
        Array.set(arr,2,3);
        Array.get(arr,0);
        for (int i : arr) {
            System.out.println(i);
        }
        String[] strings = new String[3];
        Class<? extends String[]> aClass = strings.getClass();
        System.out.println(aClass);
        Class<?> componentType = aClass.getComponentType();
        System.out.println(componentType);
    }


}
