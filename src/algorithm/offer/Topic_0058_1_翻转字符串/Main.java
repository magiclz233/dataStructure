package algorithm.offer.Topic_0058_1_翻转字符串;

/**
 * @author magic_lz
 * @version 1.0
 * @classname Main
 * @date 2021/1/8 : 17:26
 */
public class Main {
    public static void main(String[] args) {

    }

    public static String reverseWords(String s) {
        String[] ss = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = ss.length-1;i >=0; i--){
            if(ss[i].equals("")){
                continue;
            }
            sb.append(ss[i]).append(" ");
        }
        return sb.toString().trim();
    }
}
