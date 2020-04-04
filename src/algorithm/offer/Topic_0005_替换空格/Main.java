package algorithm.offer.Topic_0005_替换空格;

/**
 * TODO 将字符串的空格替换为20%
 * @author magic_lz
 * @version 1.0
 * @date 2020/4/4 23:57
 */
public class Main {

    public static void main(String[] args) {

        System.out.println(replaceSpace("1 2的 的 都是q d s s"));
        System.out.println(replaceSpace2("1 2的 的 都是q d s s"));

    }


    public static String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Character c : s.toCharArray()) {
            if(c.equals(' ')){
                stringBuilder.append("20%");
            }else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    public static String replaceSpace2(String s){
        int length = s.length();

        //将 ' '转为20% 一个字符转为三个字符,char最大使用为3*s.length
        char[] chars = new char[length * 3];

        int size = 0;
        for (int i = 0; i < length; i++) {
            Character c = s.charAt(i);

            if(c.equals(' ')){
                chars[size++] = '2';
                chars[size++] = '0';
                chars[size++] = '%';
            }else {
                chars[size++] = c;
            }
        }
        return new String(chars, 0, size);
    }
}
