package Model;

public class Singleton2 {

    private Singleton2(){};
    private volatile static Singleton2 instance;

//    public synchronized static Singleton2 getInstance() {
//        if (instance==null){
//            instance = new Singleton2();
//        }
//        return instance;
//    }


    public static Singleton2 getInstance() {
        if (instance==null){

            synchronized(Singleton2.class){
                if (instance==null){
                    instance = new Singleton2();
                }
            }



        }
        return instance;
    }
}
