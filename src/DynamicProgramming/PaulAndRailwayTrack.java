package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class PaulAndRailwayTrack {
    public static void main (String args[]) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int[] s=new int[n];
        for(int i=0;i<n;i++){
            s[i]=scanner.nextInt();
        }


        int[] t=new int[m];
        for(int j=0;j<m;j++){
            t[j]=scanner.nextInt();
        }
        int[][] dp = new int[n+1][m+1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(sol(s, t, 0, 0, dp));
    }

    private static int sol(int[] s, int[] t, int currS, int currT, int[][] dp) {
        if(currS == s.length || currT == t.length) {
            return 0;
        }

        if(dp[currS][currT] != -1) {
            return dp[currS][currT];
        }
        if(s[currS] == t[currT]) {
            return dp[currS][currT] =  sol(s, t, currS + 1, currT + 1, dp)+1;
        } else {
            int c1 = sol(s, t, currS, currT + 1, dp);
            int c2 = sol(s, t, currS + 1, currT, dp);

            return dp[currS][currT] = Math.max(c1,c2);
        }
    }

}
