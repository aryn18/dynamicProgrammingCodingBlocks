package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class Knapsack0N {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int cap = kb.nextInt();
        int wt[] = new int[n];
        int val[] = new int[n];
        for(int i=0;i<wt.length;i++){
            wt[i] = kb.nextInt();
        }
        for(int i=0;i<val.length;i++){
            val[i] = kb.nextInt();
        }
        int dp[][] = new int[n+1][cap+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        System.out.println(knapsack(wt, val,n,cap,dp));

    }
    public static int knapsack(int wt[],int val[],int n,int cap,int dp[][]){
        if(n==0 || cap==0 ){
            return 0;
        }
        if(dp[n][cap] != -1){
            return dp[n][cap];
        }
        if(wt[n-1] > cap){
            return dp[n][cap] = knapsack(wt,val,n-1,cap,dp);
        }
        return dp[n][cap] = Math.max( val[n-1] + knapsack(wt,val,n,cap-wt[n-1],dp),knapsack(wt,val,n-1,cap,dp));
    }

}