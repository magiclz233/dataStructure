package algorithm.nowcoder.huawei.pra10;

/**
 * @author 罗璋|luozhang@cnpc.com.cn
 * @version 1.0
 * @classname Test
 * @description TODO
 * @date 2020/2/26 21:38
 */
public class Test {
    public static void main(String[] args) {
        String string = stringToAscii("n￥a");
        System.out.println(string);
        String string1 = asciiToString(string);
        System.out.println(string1);
    }
    public static String stringToAscii(String value)
    {
        StringBuffer sbu = new StringBuffer();
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(i != chars.length - 1)
            {
                sbu.append((int)chars[i]).append(",");
            }
            else {
                sbu.append((int)chars[i]);
            }
        }
        return sbu.toString();
    }
    public static String asciiToString(String value)
    {
        StringBuffer sbu = new StringBuffer();
        String[] chars = value.split(",");
        for (int i = 0; i < chars.length; i++) {
            sbu.append((char) Integer.parseInt(chars[i]));
        }
        return sbu.toString();
    }
}
