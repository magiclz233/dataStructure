package thread.concurrent_art.chapter4;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName ThreadPool
 * @date 2020/1/10 16:04
 */
public interface ThreadPool<Job extends Runnable> {
    /**
     * 执行一个Job
     * @param job 执行的工作线程
     */
    void execute(Job job);

    /**
     * 关闭线程池
     */
    void shutdown();

    /**
     * 增加工作者线程
     * @param num 增加的数量
     */
    void addWorkers(int num);

    /**
     * 减少工作者线程
     * @param num 数量
     */
    void removeWorker(int num);

    /**
     * 得到正在执行的任务数量
     * @return 数量
     */
    int getJobSize();
}
