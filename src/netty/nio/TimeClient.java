package netty.nio;

/**
 * @author magic_lz
 * @version 1.0
 * @classname TimeClient
 * @date 2020/6/18 : 15:54
 */
public class TimeClient {
    public static void main(String[] args) {
        int port = 9090;
        new Thread(new TimeClientHandler("127.0.0.1",port),"TimeClient-001").start();
    }
}
