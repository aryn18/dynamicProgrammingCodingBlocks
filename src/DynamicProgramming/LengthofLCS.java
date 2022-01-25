package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class LengthofLCS{
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String s1 = kb.next();
        String s2 = kb.next();
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(lcslen(s1,s2,s1.length(),s2.length(),dp));

    }
    public static int max(int a, int b)
    {
        return (a > b)? a : b;
    }
    public static int lcslen(String s1, String s2,int m , int n,int dp[][]){
        if(m==0 || n==0){
            return 0;
        }
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        if(s1.charAt(m-1)==s2.charAt(n-1)){
            return dp[m][n] = 1 + lcslen(s1,s2,m-1,n-1,dp);
        }
        return dp[m][n] = max( lcslen(s1,s2,m-1,n,dp),lcslen(s1,s2,m,n-1,dp) );
    }

}
