package day14;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 */
public class T5 {

    public int coinChange(int[] coins, int amount) {

        int[] res = new int[amount+1];

        for (int i = 1; i < amount+1; i++) {
            res[i] = Integer.MAX_VALUE;//如果凑不出来就是最大值
        }

        for (int i = 1; i < amount+1; i++) {
            int tmp = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin < 0) continue;
                tmp = Math.min(tmp, res[i-coin]);
            }
            if (tmp==Integer.MAX_VALUE){
                res[i] = tmp;
            }else {
                res[i] = tmp+1;
            }

        }

        return res[amount]==Integer.MAX_VALUE?-1:res[amount];
    }

    public static void main(String[] args) {
        new T5().coinChange(new int[]{2}, 3);
    }


}
