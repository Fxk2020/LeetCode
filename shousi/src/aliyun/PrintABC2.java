package aliyun;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintABC2 {

    private static int state = 0;
    private static final Lock lock = new ReentrantLock();
    private static final Condition A = lock.newCondition();
    private static final Condition B = lock.newCondition();
    private static final Condition C = lock.newCondition();

    public void printA(String name){
        while (true){
            lock.lock();
            while (state%3!=0) {
                try {
                    A.await();//释放锁并等待
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(name);
            state++;
            B.signal();//唤醒B线程
            lock.unlock();
        }

    }

    public void printB(String name){
        while (true){
            lock.lock();
            while (state%3!=1) {
                try {
                    B.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(name);
            state++;
            C.signal();
            lock.unlock();
        }

    }

    public void printC(String name){
        while (true){
            lock.lock();
            while (state%3!=2) {
                try {
                    C.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(name);
            state++;
            A.signal();
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        new Thread(
                ()->{
                    new PrintABC2().printA("A");
                },"A--Thread"
        ).start();
        new Thread(
                ()->{
                    new PrintABC2().printB("B");
                },"B--Thread"
        ).start();
        new Thread(
                ()->{
                    new PrintABC2().printC("C");
                },"C--Thread"
        ).start();
    }
}
