import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String str = in.next();

        StringBuilder builder = new StringBuilder(str);
        for(int i=0;i<n-k+1;i++){
            builder.replace(i, i+k, new StringBuilder(builder.substring(i,i+k)).reverse().toString());
        }

        System.out.println(builder.toString());
    }
}