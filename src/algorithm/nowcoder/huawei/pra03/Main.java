package algorithm.nowcoder.huawei.pra03;

import java.util.*;

/**
 * @author 罗璋|luozhang@cnpc.com.cn
 * @version 1.0
 * @classname main
 * @description TODO
 * @date 2020/2/23 16:26
 */
public class Main {
    public static List<Integer> sortAndDis(List<Integer> list){
        List<Integer> lists = new ArrayList<>(new HashSet<>(list));
        Collections.sort(lists);
        return lists;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> lists = new ArrayList<>();
        while (scanner.hasNext()){

            lists.add(scanner.nextInt());
            List<Integer> integers = sortAndDis(lists);
            for (int i :
                    integers) {
                System.out.println(i);
            }
        }

    }
}
