package designpattern.builder;

/**
 * @author magic_lz
 * Description TODO 食物条目
 * @version 1.0
 * @ClassName item
 * @date 2020/1/2 13:42
 */
public interface Item {
    //实物
    String name();
    //包装
    Packing packing();
    //价格
    float price();

}
