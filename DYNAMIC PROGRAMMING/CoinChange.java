import java.util.Scanner;

public class CoinChange {

    static int count(int[] coins, int sum) {
        int n = coins.length;
        int[][] t = new int[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            t[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (coins[i - 1] <= j) {
                    t[i][j] = t[i][j - coins[i - 1]] + t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n][sum];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        int sum = sc.nextInt();
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        System.out.println(count(coins, sum));
    }

}
