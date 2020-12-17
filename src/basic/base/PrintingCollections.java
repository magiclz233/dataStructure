package basic.base;

import java.util.*;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName Test1
 * @date 2020/1/6 18:18
 */
public class PrintingCollections {
    static Collection fill(Collection<String> collection){
        collection.add("1");
        collection.add("2");
        collection.add("3");
        collection.add("1");
        return collection;
    }

    static Map fill(Map<String,String> map){
        map.put("1","1");
        map.put("2","2");
        map.put("1","1");
        return map;
    }

    public static void main(String[] args){
      System.out.println(fill(new ArrayList<>()));
      System.out.println(fill(new LinkedList<>()));
      System.out.println(fill(new HashMap<>()));
      System.out.println(fill(new HashSet<>()));
    }
}
