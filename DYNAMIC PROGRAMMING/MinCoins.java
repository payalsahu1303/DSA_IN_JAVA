import java.util.Scanner;

public class MinCoins {

    static int minCount(int[] coins, int sum) {
        int n = coins.length;
        int[][] t = new int[n + 1][sum + 1];
        int MAX = (int) 1e9;
        for (int i = 1; i <= n; i++) {
            t[i][0] = 0;
        }
        for (int j = 0; j <= sum; j++) {
            t[0][j] = MAX;
        }
        for (int j = 1; j <= sum; j++) {
            if (j % coins[0] == 0) {
                t[1][j] = 1;
            } else {
                t[1][j] = MAX;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (coins[i - 1] <= j) {
                    t[i][j] = Math.max(t[i][j - coins[i - 1]], t[i - 1][j]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n][sum] >= MAX ? -1 : t[n][sum];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        int sum = sc.nextInt();
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        System.out.println(minCount(coins, sum));
    }

}
