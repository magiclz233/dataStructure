package designpattern.proxy;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName MyRemoteClient
 * @date 2020/1/6 14:59
 */
public class MyRemoteClient {
    public static void main(String[] args){
      new MyRemoteClient().go();
    }

    public void go(){
        try {
            MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1/remote");
            String s = service.sayHello();
            System.out.println(s);
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            e.printStackTrace();
        }
    }
}
