package designpattern.exterior;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName DVD
 * @date 2020/1/4 17:48
 */
public class DVD {
    public void start(){
        System.out.println("DVD开机");
    }

    public void play(String movie){
        System.out.println("播放电影:"+movie);
    }
}
