package designpattern.proxy.demo2;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName Test
 * @date 2020/1/6 15:45
 */
public class Test {
    public static void main(String[] args){
      Image image = new ProxyImage("123");
      //图片将从磁盘加载
      image.display();
      System.out.println("");
      //图片不需要从磁盘加载
      image.display();
    }
}
