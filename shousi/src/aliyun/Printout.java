package aliyun;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程，A线程打印A，B线程打印B，C线程打印C，要求启动后顺序为ABCABC
 */
public class Printout implements Runnable{

    private String str;
    private static Lock lock;
    public Printout(String str){
        this.str = str;
        this.lock=new ReentrantLock(true);
    }

    public void run(){
        while(true){
            lock.lock();

            System.out.print(str);

            lock.unlock();
        }}

    public static void main(String[]args) throws InterruptedException {
        BlockingQueue<Printout> blockingQueue = new ArrayBlockingQueue<Printout>(5);
        Printout aout = new Printout("A");
        Printout bout = new Printout("B");
        Printout cout = new Printout("C");
        while (true){
            blockingQueue.put(aout);
            blockingQueue.put(bout);
            blockingQueue.put(cout);
        }

    }


    }