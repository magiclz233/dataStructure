package datastructure;

import java.util.HashMap;

/**
 * @author 罗璋|luozhang@cnpc.com.cn
 * @version 1.0
 * @classname HashMapTest
 * @description TODO
 * @date 2020/2/19 10:34
 */
public class HashMapTest {

    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>(6);

        /*
            (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
         */
        System.currentTimeMillis()
        int key = 131072;
        int h = Integer.hashCode(key);
        int i = h >>> 16;
        int i1 = h ^ i;
        System.out.println(h+"\n~~~\n"+i+"\n~~~\n"+i1);
    }
}
