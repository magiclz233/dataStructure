package thread.chapter4;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO JMX查看一个普通Java程序包含那些线程
 * @version 1.0
 * @ClassName MultiThread
 * @date 2020/1/9 21:22
 */
public class MultiThread {
    public static void main(String[] args){
        //获取Java线程管理MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false,false);

        for (ThreadInfo threadInfo:
             threadInfos) {
            System.out.println(threadInfo.getThreadName()+"~~"+threadInfo.getThreadId());
        }

        /*
        Monitor Ctrl-Break~~6
        Attach Listener~~5
        Signal Dispatcher~~4 分发处理发送给JVM信号的线程
        Finalizer~~3       调用对象Finalizer方法的线程
        Reference Handler~~2  清除Reference线程
        main~~1  main线程，程序入口
         */
    }
}
