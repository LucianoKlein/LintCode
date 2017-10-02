package dp._322LeetCoinChange;

public class Solution {
	public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] f = new int[amount + 1];//0 ... amount
        int i, j;
        f[0] = 0; //init 
        for (i = 1; i <= amount; ++i) {
            //打擂台算法
            f[i] = Integer.MAX_VALUE;
            //选择硬币
            for (j = 0; j < n; ++j) {
                if (i >= coins[j] && f[i - coins[j]] != Integer.MAX_VALUE && f[i - coins[j]] + 1 < f[i]) {
                    f[i] = f[i - coins[j]] + 1;
                }
            }
        }
        if (f[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return f[amount];
    }
}
