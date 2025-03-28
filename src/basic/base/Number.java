package basic.base;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author magic_lz
 * @version 1.0
 * @date 2020/3/29 16:03
 */
public class Number {
    public static void main(String[] args) {
        String s1 = "1,3,6-8,11-100000";
        String s2 = "1,3,11-15";
        System.out.println(System.currentTimeMillis());
        boolean contain = isContain(s1, s2);
        System.out.println(System.currentTimeMillis());
        System.out.println(contain);
    }

    public static boolean isContain(String big,String small){
        List<Integer> bigList = new ArrayList<>(splitStr(big));
        List<Integer> smallList = new ArrayList<>(splitStr(small));
        return bigList.containsAll(smallList);
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
