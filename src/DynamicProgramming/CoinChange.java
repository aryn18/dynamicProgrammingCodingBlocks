package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {
    private static int sol(int[] coins, int curr, int amt, int[][] dp) {

        if(amt == 0) {
            return 1;
        }

        if(curr == coins.length) {
            return 0;
        }

        if(dp[curr][amt] != -1) {
            return dp[curr][amt];
        }
        int pick = 0;
        if(coins[curr] <= amt) {
            pick = sol(coins, curr, amt - coins[curr], dp);
        }

        int dontPick = sol(coins, curr + 1, amt, dp);
        return dp[curr][amt] = pick + dontPick;
    }
    public static void main(String args[]) {

        Scanner sc=new Scanner(System.in);
        int amt=sc.nextInt();
        int n=sc.nextInt();
        int[] coins=new int[n];
        for(int i=0;i<n;i++){
            coins[i]=sc.nextInt();
        }

        int[][] dp = new int[n + 1][amt + 1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        System.out.println(sol(coins, 0, amt, dp));
    }

}
