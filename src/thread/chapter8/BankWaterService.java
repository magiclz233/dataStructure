package thread.chapter8;

import java.util.Map;
import java.util.concurrent.*;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName BankWaterService
 * @date 2020/1/15 11:28
 */
public class BankWaterService implements Runnable {
    public static void main(String[] args){
        BankWaterService service = new BankWaterService();
        service.count();
    }
    /**
     *     创建4个屏障，处理完之后执行当前类的run方法
      */
    private CyclicBarrier c = new CyclicBarrier(4,this);

    /**
     * 4个sheet,四个线程
     */
    private Executor executor = Executors.newFixedThreadPool(4);

    private ConcurrentHashMap<String,Integer> sheetBankWater = new ConcurrentHashMap<>();

    private void count(){
        for (int i = 0; i < 4; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    sheetBankWater.put(Thread.currentThread().getName(),1);

                    try {
                        c.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
    @Override
    public void run() {
        int result = 0;

        //汇总每个sheet计算后的结果
        for (Map.Entry<String ,Integer> sheet: sheetBankWater.entrySet()){
            result += sheet.getValue();
        }

        //将结果输出
        sheetBankWater.put("result",result);
        System.out.println(result);
    }
}
