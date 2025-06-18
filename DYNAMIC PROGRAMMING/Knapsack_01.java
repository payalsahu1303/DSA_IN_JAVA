import java.util.Scanner;

public class Knapsack_01 {

    static int knapsack(int[] wt, int[] val, int W, int n, int[][] t) {
        if (W == 0 || n == 0) {
            return 0;
        }
        if (t[n][W] != -1) {
            return t[n][W];
        }

        if (wt[n - 1] <= W) {
            return t[n][W] = Math.max(val[n - 1] + knapsack(wt, val, W - wt[n - 1], n - 1, t),
                    knapsack(wt, val, W, n - 1, t));
        } else if (wt[n - 1] > W) {
            return t[n][W] = knapsack(wt, val, W, n - 1, t);
        }

        return knapsack(wt, val, W, n - 1, t);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no. of items :");
        int n = sc.nextInt();
        int[] wt = new int[n];
        int[] val = new int[n];
        System.out.print("Enter the max capacity :");
        int W = sc.nextInt();
        System.out.print("Enter weights of items :");

        for (int i = 0; i < n; i++) {
            wt[i] = sc.nextInt();
        }
        System.out.print("Enter the items values :");

        for (int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
        }
        int[][] t = new int[n + 1][W + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                t[i][j] = -1;
            }
        }
        System.out.println("Maximum profit: " + knapsack(wt, val, W, n, t));

    }

}