package netty.nio;

/**
 * @author magic_lz
 * @version 1.0
 * @classname TimeServer
 * @date 2020/6/18 : 14:50
 */
public class TimeServer {
    public static void main(String[] args) {
        int port = 9090;
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
        new Thread(timeServer,"NIO-TimeServer-001").start();
    }
}
