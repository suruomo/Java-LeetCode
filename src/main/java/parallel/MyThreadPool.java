package parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.stream.IntStream;

/**
 * @Author: suruomo
 * @Date: 2021/8/24 15:07
 * @Description: 简易线程池实现
 */
public class MyThreadPool {
        /**
        * 存放任务的阻塞队列
        */
        BlockingQueue<Runnable> taskQueue;
        /**
         *  线程列表
         */
        List<MyThread> threads;

    MyThreadPool(BlockingQueue<Runnable> taskQueue, int threadSize) {
            this.taskQueue = taskQueue;
            threads = new ArrayList<>(threadSize);
            // 初始化线程，并定义名称
            IntStream.rangeClosed(1, threadSize).forEach((i)-> {
                MyThread thread = new MyThread("yes-task-thread-" + i);
                thread.start();
                threads.add(thread);
            });
        }
        //提交任务只是往任务队列里面塞任务
        public void execute(Runnable task) throws InterruptedException {
            taskQueue.put(task);
        }

        class MyThread extends Thread { //自定义一个线程
            public MyThread(String name) {
                super(name);
            }
            @Override
            public void run() {
                while (true) { //死循环
                    Runnable task = null;
                    try {
                        task = taskQueue.take(); //不断从任务队列获取任务
                    } catch (InterruptedException e) {
                        System.out.println(e.toString());
                    }
                    task.run(); //执行
                }
            }
        }
}
