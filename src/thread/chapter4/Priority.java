package thread.chapter4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName Priority
 * @date 2020/1/9 21:37
 */
public class Priority {
    private static volatile boolean notStart = true;
    private static volatile boolean notEnd = true;

    public static void main(String[] args) throws InterruptedException {
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int priority = i < 5 ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY;
            Job job = new Job(priority);
            jobs.add(job);
            Thread thread = new Thread(job,"Thread:"+i);
            thread.setPriority(priority);
            thread.start();
        }
        notStart = false;
        TimeUnit.SECONDS.sleep(2);
        notEnd = false;
        for (Job job :
                jobs) {
            System.out.println("job priority:"+job.priority+"~~ count:"+job.jobCount);
        }
    }

    static class Job implements Runnable{
        private int priority;
        private long jobCount;

        public Job(int pro){
            this.priority = pro;
        }
        @Override
        public void run() {
            while (notStart)
                Thread.yield();
            while (notEnd)
                Thread.yield();
                jobCount++;
        }
    }
}
