package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumPathSum {
    public static void main (String args[]) {
        Scanner scanner=new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int[][] grid=new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                grid[i][j]=scanner.nextInt();
            }
        }
        int[][] dp = new int[row+1][col+1];
        for (int[] i: dp)
            Arrays.fill(i, -1);
        System.out.println(solve(grid,0,0,row-1,col-1,dp));

    }

    public static int solve(int[][] grid,int cr,int cc,int dr,int dc,int[][] dp){
        if(cr==dr && cc==dc){
            return grid[cr][cc];
        }
        if(cr>dr || cc>dc){
            return Integer.MAX_VALUE;
        }
        if(dp[cr][cc]!=-1){
            return dp[cr][cc];
        }
        int c1 = solve(grid,cr,cc+1,dr,dc,dp);
        int c2 = solve(grid,cr+1,cc,dr,dc,dp);
        return dp[cr][cc] = Math.min(c1,c2)+grid[cr][cc];
    }

}
