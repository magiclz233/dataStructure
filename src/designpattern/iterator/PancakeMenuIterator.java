package designpattern.iterator;

import java.util.ArrayList;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName DinnerMenuIterator
 * @date 2020/1/5 17:48
 */
public class PancakeMenuIterator implements Iterator {
    ArrayList menuItems;
    //记录当前数组遍历位置
    int position = 0;

    public PancakeMenuIterator(ArrayList m){
        this.menuItems = m;
    }
    @Override
    public boolean hasNext() {
        if(position >= menuItems.size() || menuItems.get(position) == null){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public Object next() {
        MenuItem menuItem = (MenuItem) menuItems.get(position);
        position = position + 1;
        return menuItem;
    }
}
