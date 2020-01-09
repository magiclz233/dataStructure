package basic.annotation;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName AnnoDemo
 * @date 2020/1/7 17:31
 */

@Demo(value = "name",name = "AnnoDemo")
public class AnnoDemo {
    private String name;

    public AnnoDemo(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
