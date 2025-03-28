package algorithm.leetcode.practice.Topic_0017_电话号码的字母组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author magic_罗璋
 * @date 2020/2/29 0:44
 */

public class Main {
    public static void main(String[] args) {

    }

    public List<String> letterCombinations(String s){
        if(s.length() < 2){
            return Arrays.asList(contains(s.charAt(0)));
        }
        char[] chars = s.toCharArray();
        List<String[]> list = new ArrayList<>();
        for (char c : chars) {
            list.add(contains(c));
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 1; j < list.get(i).length; j++) {

            }
        }
        return null;
    }
    public String[] contains(char i){
        switch (i){
            case '2': return new String[]{"a","b","c"};
            case '3': return new String[]{"d","e","f"};
            case '4': return new String[]{"g","h","i"};
            case '5': return new String[]{"j","k","l"};
            case '6': return new String[]{"m","n","o"};
            case '7': return new String[]{"p","q","r","s"};
            case '8': return new String[]{"t","u","v"};
            case '9': return new String[]{"w","x","y","z"};
            default: return null;
        }
    }
}
