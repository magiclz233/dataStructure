package designpattern.iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author magic_lz
 * Description TODO 煎饼屋菜单
 * @version 1.0
 * @ClassName PancakeHouseMenu
 * @date 2020/1/5 17:55
 */
public class PancakeHouseMenu {
    ArrayList menuItems;

    public PancakeHouseMenu(){
        menuItems = new ArrayList();

        addItems("套餐一","煎饼,稀饭",10,true);
        addItems("套餐二","煎饼,茶叶蛋,牛奶",15,false);
    }

    public void addItems(String name,String desc,double price,boolean vege){
        MenuItem menuItem = new MenuItem(name,desc,vege,price);
        menuItems.add(menuItem);
    }

    public ArrayList getMenuItems(){
        return menuItems;
    }

    //本地自己写的迭代器
//    public Iterator createIterator(){
//        return new PancakeMenuIterator(menuItems);
//    }

    public Iterator createIterator(){
        return menuItems.iterator();
    }

    //其他方法 依赖于ArrayList
}
