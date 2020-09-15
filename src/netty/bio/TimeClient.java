package netty.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author magic_lz
 * @version 1.0
 * @classname TimeClient
 * @date 2020/6/18 : 13:41
 */
public class TimeClient {

    public static void main(String[] args) {
        int port = 9090;
        if(args != null && args.length > 0){
            try {
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e){
                port = 8080;
            }
        }
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            socket = new Socket("localhost",port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);
            out.println(TimeServerHandler.TIME_NOW);
            System.out.println("发送消息成功:"+TimeServerHandler.TIME_NOW);
            String res = in.readLine();
            System.out.println("当前时间为:"+res);

        }catch (IOException e){
        }finally {
            if(in != null){
                try {
                    in.close();
                }catch (IOException e1){
                    e1.printStackTrace();
                }
            }
            if(out != null){
                out.close();
                out = null;
            }
            if(socket != null){
                try {
                    socket.close();
                }catch (IOException e1){
                    e1.printStackTrace();
                }
                socket = null;
            }
        }
    }
}
