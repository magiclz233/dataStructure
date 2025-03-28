package datastructure;

import java.util.HashMap;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName test
 * @date 2019/12/24 17:56
 */
public class Test {

    public static void main(String[] args){
        ji();
        HashMap hashMap = new HashMap(1);
        hashMap.put(null,null);
        Object o = hashMap.get(null);
        System.out.println(o);
    }

    public static void ji(){
        int sum = 0;
        for (int i = 100; i<=200;i++){
            if(i%2==1){
                System.out.println(i);
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
