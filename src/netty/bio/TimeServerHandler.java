package netty.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author magic_lz
 * @version 1.0
 * @classname TimeServerHandler
 * @date 2020/6/18 : 11:54
 */
public class TimeServerHandler implements Runnable {
    public static final String TIME_NOW = "当前时间";
    private Socket socket;

    public TimeServerHandler(Socket socket){
        this.socket = socket;
    }


    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;

        try {
           in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
           out = new PrintWriter(this.socket.getOutputStream(),true);
           String time = null;
           String body = null;
           while (true){
               body = in.readLine();
               if(body == null){
                   break;
               }
               System.out.println("客户端发来命令:"+body);
               time = TIME_NOW.equalsIgnoreCase(body) ? LocalDateTime.now().toString() : "指令错误";
               out.println(time);
           }
        } catch (IOException e) {
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
            if(this.socket != null){
                try {
                    this.socket.close();
                }catch (IOException e1){
                    e1.printStackTrace();
                }
                this.socket = null;
            }
        }
    }
}
