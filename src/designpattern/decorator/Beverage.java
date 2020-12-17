package designpattern.decorator;

/**
 * @author magic_lz
 * Description TODO 咖啡产品超类
 * @version 1.0
 * @ClassName Beverage
 * @date 2020/1/3 15:35
 */
public abstract class Beverage {
    private String description = "咖啡";
    private int size;

    public int getSize(){
        return size;
    }

    public void setSize(int s){
        this.size = s;
    }

    public void setDescription(String d){
        this.description = d;
    }
    public String getDescription(){
        return description;
    }

    public abstract double cost();
}
