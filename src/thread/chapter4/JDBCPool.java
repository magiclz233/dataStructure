package thread.chapter4;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName JDBCPool
 * @date 2020/1/10 15:08
 */
public class JDBCPool {
    LinkedList<Connection> pool = new LinkedList<>();

    JDBCPool(int initialSize){
        if(initialSize > 0){
            for (int i = 0; i < initialSize; i++) {
                pool.add(ConnectionDriver.createConnection());
            }
        }
    }

    public void releaseConnection(Connection connection){
        if(connection != null){
            synchronized (pool){
                pool.addLast(connection);
                pool.notify();
            }
        }
    }

    public Connection fetchConnection(long mills) throws InterruptedException {
        synchronized (pool){
            if(mills < 0){
                while (pool.isEmpty()){
                    pool.wait();
                }
                return pool.removeFirst();
            }else {
                long future = System.currentTimeMillis()+mills;
                long remaining = mills;
                while (pool.isEmpty() && remaining> 0){
                    pool.wait(remaining);
                    remaining = future - System.currentTimeMillis();
                }
                Connection result = null;
                if(!pool.isEmpty()){
                    result = pool.removeFirst();
                }
                return result;
            }
        }
    }
}
