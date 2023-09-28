package parallel;

import java.util.concurrent.*;

/**
 * @Author: suruomo
 * @Date: 2021/8/24 14:43
 * @Description: 线程池
 */
public class ThreadPool implements Runnable{
    int i=0;

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor pool=new ThreadPoolExecutor(10,15,30, TimeUnit.SECONDS,new ArrayBlockingQueue<>(10),new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 10; i++) {
            ThreadPool thread=new ThreadPool();
            pool.execute(thread);
            Thread.sleep(1000);
        }
        pool.shutdown();
    }

    @Override
    public void run() {
        System.out.println(++i);
    }
}
