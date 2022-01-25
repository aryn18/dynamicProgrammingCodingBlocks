package DynamicProgramming;

//Count of different ways to express N as the sum of 1, 3 and 4

import java.util.Arrays;
import java.util.Scanner;

public class CountOfDifferentWaysToExpress {
    public static void main (String args[]) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        long[] dp=new long[n+1];
        Arrays.fill(dp,-1);
        System.out.println(sol(n,dp));
    }

    public static long sol(int n, long[] dp){
        if(n==0 || n==1 || n==2){
            return 1;
        }
        if(n==3){
            return 2;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        long c1=sol(n-1,dp);
        long c2=sol(n-3,dp);
        long c3=sol(n-4,dp);
        return dp[n]=c1+c2+c3;
    }
}
