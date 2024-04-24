package aliyun;

public class PrintABC {

    private final static Object lock = new Object();
    private static int state = 0;

    public static void printABC(String name, int targetNum) {
        while (true){
            synchronized (lock){
                while (state%3!=targetNum) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(name);
                state++;
                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args){
        new Thread(
                ()-> {
                    PrintABC.printABC("A", 0);
                },"A--Thread"
        ).start();
        new Thread(
                ()->{
                    PrintABC.printABC("B",1);
                },"B--Thread"
        ).start();
        new Thread(
                ()->{
                    PrintABC.printABC("C", 2);
                },"C--Thread"
        ).start();
    }


}
