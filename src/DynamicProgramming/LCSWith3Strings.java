package DynamicProgramming;

import java.util.Scanner;

public class LCSWith3Strings {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String s1 = kb.next();
        String s2 = kb.next();
        String s3 = kb.next();
        int[][][] dp = new int[200][200][200];
        for (int i = 0; i < 200; i++)
        {
            for (int j = 0; j < 200; j++)
            {
                for (int k = 0; k < 200; k++)
                {
                    dp[i][j][k] = -1;
                }
            }
        }

        System.out.println(lcslen(s1,s2,s3,s1.length(),s2.length(),s3.length(),dp));



    }
    public static int lcslen(String s1, String s2,String s3 ,int m , int n,int p,int dp[][][]){
        if(m==0 || n==0 || p==0){
            return 0;
        }
        if(dp[m][n][p] != -1){
            return dp[m][n][p];
        }
        if( s1.charAt(m-1)==s2.charAt(n-1) && s2.charAt(n-1)==s3.charAt(p-1)){

            return dp[m][n][p] = 1 + lcslen(s1,s2,s3,m-1,n-1,p-1,dp);

        }
        else{
            return dp[m][n][p] = Math.max( Math.max(lcslen(s1,s2,s3,m-1,n,p,dp),lcslen(s1,s2,s3,m,n-1,p,dp)) ,lcslen(s1,s2,s3,m,n,p-1,dp) );
        }


    }

}