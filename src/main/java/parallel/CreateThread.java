package parallel;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: suruomo
 * @Date: 2021/8/24 14:26
 * @Description: 创建线程方法
 */
public class CreateThread{
    /**
     * 1.继承Thread
     */
    class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }

    /**
     * 2.实现Runnable
     */
    class MyThread1 implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
    /**
     * 3.实现Callable
     */
    static class MyThread2 implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            return 1;
        }
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread2 thread2=new MyThread2();
        FutureTask<Integer> task=new FutureTask<>(thread2);
        new Thread(task,"ha").start();
        System.out.println(task.get());
    }
}
