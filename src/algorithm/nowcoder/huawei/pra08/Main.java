package algorithm.nowcoder.huawei.pra08;

import java.util.*;

/**
 * @author 罗璋|luozhang@cnpc.com.cn
 * @version 1.0
 * @classname Main
 * @description TODO
 * @date 2020/2/26 20:27
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        Map<Integer,Integer> map = new TreeMap<>();
        int count = 0;
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            int i = s.indexOf(" ");
            int key = Integer.parseInt(s.substring(0, i));
            int value = Integer.parseInt(s.substring(i+1));
            if(map.get(key) != null){
                map.put(key, map.get(key)+value);
            }else {
                map.put(key, value);
            }
            if(num == ++count){
                break;
            }
        }

        for (Map.Entry<Integer, Integer> e :
                map.entrySet()) {
            Integer key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key+" "+value);
        }
    }
}
