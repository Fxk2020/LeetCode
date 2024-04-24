package week1;

import java.util.Random;

public class radNums {

    private static Random random = new Random();
    public static void main(String[] args) {
        for (int i = 0; i < 200; i++) {
            int num1 = random.nextInt(1000)+1;
            int num2 = random.nextInt(10)+1;
            System.out.println(num1+" "+num2);
        }
    }


}
