package designpattern.proxy;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName MyRemote
 * @date 2020/1/6 14:46
 */
public interface MyRemote extends Remote {
    /**
     * 传输的数据必须经过序列化
     * @return String
     * @throws RemoteException
     */
    public String sayHello() throws RemoteException;
}
