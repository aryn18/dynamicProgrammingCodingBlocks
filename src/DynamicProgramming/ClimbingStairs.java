package DynamicProgramming;

import java.util.Scanner;

public class ClimbingStairs {
    public static void main (String[] args) {

        Scanner kb =new Scanner(System.in);
        int n = kb.nextInt();
        int dp[] = new int[100];
        for(int i=0;i<100;i++){
            dp[i] = -1;
        }
        System.out.println(ClimbStairs(n,dp));

    }
    public static int ClimbStairs(int n,int dp[]){
        if(n<0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        if(dp[n] !=-1){
            return dp[n];
        }
        else{
            return dp[n] = ClimbStairs(n-1,dp) + ClimbStairs(n-2,dp);
        }
    }

}
