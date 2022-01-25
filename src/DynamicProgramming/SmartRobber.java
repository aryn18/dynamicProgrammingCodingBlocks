package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class SmartRobber {
    private static int maxP(int[] nums, int curr, int n, int[] cache) {

        if(curr >= n) {
            return 0;
        }

        if(cache[curr] != -1) {
            return cache[curr];
        }
        int rob = nums[curr] + maxP(nums, curr + 2, n, cache);
        int dontRob = maxP(nums, curr + 1, n, cache);

        return cache[curr] = Math.max(rob, dontRob);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- != 0){
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++){
                nums[i] = sc.nextInt();
            }
            int[] cache = new int[n + 1];

            Arrays.fill(cache, -1);
            System.out.println(maxP(nums, 0, n, cache));

        }
    }

}
