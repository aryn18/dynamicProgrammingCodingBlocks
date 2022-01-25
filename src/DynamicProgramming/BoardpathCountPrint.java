package DynamicProgramming;

import java.util.Scanner;

public class BoardpathCountPrint {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Path(n,m,0,"");
        System.out.println();

        System.out.println(count);

    }

    static int count = 0;
    public static void Path(int n, int m,int c,String res){
        if(c==n){
            System.out.print(res+" ");
            count++;
            return;
        }
        if(c>n){
            return;
        }

        for(int i=1;i<=m;i++){
            Path(n,m,c+i,res+i);
        }
    }

}
