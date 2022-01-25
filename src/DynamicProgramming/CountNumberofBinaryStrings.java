package DynamicProgramming;

import java.util.Scanner;

public class CountNumberofBinaryStrings {
    public static long countStrings(long n)
    {
        if(n < 1)
            return 0;
        long C0 = 1;
        long C1 = 1;

        for(int i=1; i<n; i++)
        {
            long temp = C1;
            C1 = C0;
            C0 = C0 + temp;
        }

        return C0 + C1;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- != 0){
            long n = sc.nextLong();
            System.out.println(countStrings(n));
        }
    }

}
