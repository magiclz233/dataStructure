package designpattern.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName PancakeMenuIterator1
 * @date 2020/1/5 18:29
 */
public class PancakeMenuIterator1 implements Iterator {
    ArrayList menuItems;
    //记录当前数组遍历位置
    int position = 0;

    public PancakeMenuIterator1(ArrayList<MenuItem> m){
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

    @Override
    public void remove() {
        if(position <= 0){
            throw new IllegalStateException("无数据可以删除,为空");
        }
        if(menuItems.get(position-1) != null){
           menuItems.remove(position);
        }
    }
}
