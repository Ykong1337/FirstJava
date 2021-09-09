package com.ftg.learn.Leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

public class L_of103 {

    //{1,2,5}       11
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0)
            return -1;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 1, dp.length, Integer.MAX_VALUE);

        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                if (dp[j - coin] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                }
            }
        }

        if (dp[amount] != Integer.MAX_VALUE)
            return dp[amount];
        return -1;
    }

    @Test
    public void test() {
        System.out.println(new L_of103().coinChange(new int[]{1, 2, 5}, 11));
    }
}
