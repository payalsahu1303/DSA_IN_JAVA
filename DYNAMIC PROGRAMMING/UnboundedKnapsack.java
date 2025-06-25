// User function Template for Java

import java.util.Scanner;

class UnboundedKnapsack {
    static int knapSack(int val[], int wt[], int capacity) {
        int n = wt.length;
        int[][] t = new int[n + 1][capacity + 1];
        for (int i = 0; i <= n; i++) {
            t[i][0] = 0;
        }
        for (int j = 1; j <= capacity; j++) {
            t[0][j] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < capacity + 1; j++) {
                if (wt[i - 1] <= j) {
                    t[i][j] = Math.max(val[i - 1] + t[i][j - wt[i - 1]], t[i - 1][j]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[n][capacity];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no. of items :");
        int n = sc.nextInt();
        int[] wt = new int[n];
        int[] val = new int[n];
        System.out.print("Enter the max capacity :");
        int capacity = sc.nextInt();
        System.out.print("Enter weights of items :");

        for (int i = 0; i < n; i++) {
            wt[i] = sc.nextInt();
        }
        System.out.print("Enter the items values :");

        for (int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
        }

        System.out.println("Maximum profit: " + knapSack(val, wt, capacity));
    }

}