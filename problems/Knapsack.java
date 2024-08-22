package problems;

import java.util.Arrays;

public class Knapsack {
    
    /*
    most optimized
    static int knapSack(int W, int wt[], int val[], int n)
    {
        // making and initializing dp array
        int []dp = new int[W + 1];
    
    
        for (int i = 1; i < n + 1; i++) {
            for (int w = W; w >= 0; w--) {
        
                if (wt[i - 1] <= w)
                
                // finding the maximum value
                dp[w] = Math.max(dp[w], dp[w - wt[i - 1]] + val[i - 1]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[W]; // returning the maximum value of knapsack
    }*/

    
     // we can further improve the above Knapsack function's space
    // complexity
    static int knapSack(int W, int wt[], int val[], int n)
    {
        int i, w;
        int [][]K = new int[2][W + 1];
        
        // We know we are always using the current row or
        // the previous row of the array/vector . Thereby we can
        // improve it further by using a 2D array but with only
        // 2 rows i%2 will be giving the index inside the bounds
        // of 2d array K
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    // Base case
                    K[i % 2][w] = 0;
                }
                else if (wt[i - 1] <= w) {
                    // Fill row with updated weight taking the current one
                    K[i % 2][w] = Math.max(val[i - 1] + K[(i - 1) % 2] [w - wt[i - 1]], K[(i - 1) % 2][w]);
                }
                else {
                    // Fill row with updated weight not taking the current  one
                    K[i % 2][w] = K[(i - 1) % 2][w];
                }
            }

            System.out.println("i=" + i);
            for (int x = 0; x < K.length; x++) {
                System.out.println(Arrays.toString(K[x]));
            }
        }

        System.out.println("size of K=" + K.length + " " + K[0].length);
        for (int x = 0; x < K.length; x++) {
            System.out.println(Arrays.toString(K[x]));
        }

        return K[n % 2][W];
    }
    
    // Driver code
    public static void main(String[] ar)
    {
        int val[] = { 6, 10, 12 };
        int wt[] = { 1, 2, 3 };
        int W = 5;
        int n = val.length;
        System.out.print(knapSack(W, wt, val, n));
    }
}