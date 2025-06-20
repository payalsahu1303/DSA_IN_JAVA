import java.util.Scanner;

public class Knapsack01_TopDown {
    static int knapsack(int[] wt, int[] val, int W, int n) {
        int[][] t = new int[n + 1][W + 1];

        // Inialization of first row and first column by 0 is default

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (wt[i - 1] <= j) {
                    t[i][j] = Math.max(val[i - 1] + t[i - 1][j - wt[i - 1]], t[i - 1][j]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[n][W];
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

        System.out.println("Maximum profit: " + knapsack(wt, val, W, n));
    }
}