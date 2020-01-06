package designpattern.exterior;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO 投影仪
 * @version 1.0
 * @ClassName projector
 * @date 2020/1/4 17:50
 */
public class Projector {
    void start(){
        System.out.println("投影仪开机");
    }

    void set(){
        System.out.println("设置投影仪");
    }

    void work(){
        System.out.println("连接DVD");
    }
}
