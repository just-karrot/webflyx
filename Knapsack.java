import java.util.Scanner;

public class Experiment3 {

    static int knapsack(int W, int wt[], int val[], int n) {
        int dp[][] = new int[n + 1][W + 1];
        int i, w;

        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    dp[i][w] = 0;
                else if (wt[i - 1] <= w)
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, W, i;

        System.out.print("Enter number of items: ");
        n = sc.nextInt();
        int val[] = new int[n], wt[] = new int[n];

        System.out.println("Enter values:");
        for (i = 0; i < n; i++) val[i] = sc.nextInt();

        System.out.println("Enter weights:");
        for (i = 0; i < n; i++) wt[i] = sc.nextInt();

        System.out.print("Enter knapsack capacity: ");
        W = sc.nextInt();

        System.out.println("Maximum value: " + knapsack(W, wt, val, n));
    }
}
