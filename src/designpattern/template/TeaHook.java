package designpattern.template;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName Tea
 * @date 2020/1/4 20:05
 */
public class TeaHook extends CoffeineBeverageHook {
    @Override
    void brew() {
        System.out.println("煮茶");
    }

    @Override
    void addCond() {
        System.out.println("加入柠檬");
    }

    @Override
    boolean customerWantsCond(){
        String answer = getUserInput();
        if(answer.toLowerCase().startsWith("y")){
            return true;
        }else {
            return false;
        }
    }

    private String getUserInput(){
        String answer = null;
        System.out.println("请输入是否添加调剂品(y/n)?");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(answer == null){
            return "no";
        }
        return answer;
    }
}
