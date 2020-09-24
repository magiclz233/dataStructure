package algorithm.offer.Topic_0039_数组中出现次数超过一半的数字;

import java.util.HashMap;
import java.util.Map;

/**
 * @author magic_lz
 * @version 1.0
 * @classname Main
 * @date 2020/9/23 : 9:18
 */
public class Main {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                Integer value = map.get(num);
                map.put(num, value + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }
        return Integer.MIN_VALUE;
    }


    public int majorityElement1(int[] nums) {
        int x = 0, v = 0;
        for (int num : nums) {
            if (v == 0) {
                x = num;
            }
            v += num == x ? 1 : -1;
        }
        return x;
    }
}
