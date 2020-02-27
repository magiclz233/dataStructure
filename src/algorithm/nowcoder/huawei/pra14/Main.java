package algorithm.nowcoder.huawei.pra14;

import java.util.*;

/**
 * @author 罗璋|luozhang@cnpc.com.cn
 * @version 1.0
 * @classname Main
 * @description TODO
 * @date 2020/2/27 14:24
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        List<String> lists = new ArrayList<>(num);
        while (num-->0&&scanner.hasNext()) {
            lists.add(scanner.nextLine());
        }
        Collections.sort(lists);
        for (String list : lists) {
            System.out.println(list);
        }
    }
}
