import java.util.Scanner;

public class RodCutting {
    static int cutRod(int[] prices) {
        int n = prices.length;
        int[] length = new int[n];

        int[][] t = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            length[i] = i + 1;
        }

        for (int i = 0; i <= n; i++) {
            t[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (length[i - 1] <= j) {
                    t[i][j] = Math.max(prices[i - 1] + t[i][j - length[i - 1]], t[i - 1][j]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[n][n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] prices = new int[n];

        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        System.out.println(cutRod(prices));
    }
}
