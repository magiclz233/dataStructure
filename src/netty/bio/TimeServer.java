package netty.bio;

import netty.bio_new.TimeServerHandlerExecutePool;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author magic_lz
 * @version 1.0
 * @classname TimeServer
 * @date 2020/6/18 : 11:50
 */
public class TimeServer {

    public static void main(String[] args) throws IOException {
        int port = 9090;
        if(args != null && args.length > 0){
            try {
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e){
                port = 8080;
            }
        }
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("服务端端口号为:"+port);
            Socket socket = null;
            TimeServerHandlerExecutePool timeServerHandlerExecutePool = new TimeServerHandlerExecutePool(50,100);
            while (true){
                socket = server.accept();
                timeServerHandlerExecutePool.execute(new TimeServerHandler(socket));
            }
        }finally {
            if(server != null){
                System.out.println("关闭时间bio");
                server.close();
                server = null;
            }
        }
    }
}
