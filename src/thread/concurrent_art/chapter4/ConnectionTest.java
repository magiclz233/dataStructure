package thread.concurrent_art.chapter4;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName ConnectionTest
 * @date 2020/1/10 15:31
 */
public class ConnectionTest {
    static JDBCPool jdbcPool = new JDBCPool(10);
    static CountDownLatch start = new CountDownLatch(1);
    static CountDownLatch end;

    public static void main(String[] args) throws InterruptedException {
      int threadCount = 10;
      end = new CountDownLatch(threadCount);
      int count = 20;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();

        for (int i = 0; i < threadCount; i++) {
            Runnable target;
            Thread thread = new Thread(new ConnectionRunner(count,got,notGot),"ConnectionRunner");
            thread.start();
            
        }
        start.countDown();
        end.await();
        System.out.println("total invoke: " + (threadCount * count));
        System.out.println("got connection: " + got);
        System.out.println("not got connection " + notGot);
    }

    static class ConnectionRunner implements Runnable{
        int count;
        AtomicInteger got;
        AtomicInteger notGot;

        ConnectionRunner(int count,AtomicInteger got,AtomicInteger notGot){
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }


        @Override
        public void run() {
            try {
                start.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (count > 0){
                try {
                    Connection connection = jdbcPool.fetchConnection(1000);
                    if(connection != null){
                        connection.createStatement();
                        connection.commit();

                        jdbcPool.releaseConnection(connection);
                        got.incrementAndGet();
                    }else {
                        notGot.incrementAndGet();
                    }
                } catch (InterruptedException | SQLException e) {
                    e.printStackTrace();
                }finally {
                    count --;
                }
            }
            end.countDown();
        }
    }
}
