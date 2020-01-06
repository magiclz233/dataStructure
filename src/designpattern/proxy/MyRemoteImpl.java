package designpattern.proxy;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName MyRemoteImpl
 * @date 2020/1/6 14:48
 */
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {
    protected MyRemoteImpl() throws RemoteException {

    }

    @Override
    public String sayHello() {
        return "hello world say hey";
    }

    public static void main(String[] args){
        try {
            MyRemote remote = new MyRemoteImpl();
            Naming.rebind("remote",remote);
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
