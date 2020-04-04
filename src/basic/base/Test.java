package basic.base;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author magic_lz
 * @version 1.0
 * @date 2020/3/29 15:35
 */
public class Test {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>(4);
        map.put("1-5","M11");
        map.put("6-15","M12");
        map.put("1-2","M21");
        map.put("1-3","M31");
        System.out.println(Test.reset(map).toString());
    }

    public static Map<String,String> reset(Map<String,String> map){
        HashMap<String,String[]> stringHashMap = new HashMap<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();


            System.out.println(entry.getValue());
        }
        return map;
    }

    private static Set<Integer> splitStr(String str) {
        Set<Integer> strSet = new HashSet<>();
        String[] split = str.split(",");
        for (String s: split) {
            if(s.contains("-")){
                int start = Integer.parseInt(s.substring(0,s.indexOf("-")));
                int end = Integer.parseInt(s.substring(s.indexOf("-")+1));

                for (int i = start;i<=end; i++){
                    strSet.add(i);
                }
            }else {
                strSet.add(Integer.parseInt(s));
            }
        }
        return strSet;
    }
}
