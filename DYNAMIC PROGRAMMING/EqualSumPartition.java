import java.util.Scanner;

public class EqualSumPartition {
    static boolean equalSum(int[] arr) {
        int sum = 0, n = arr.length;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        boolean[][] t = new boolean[n + 1][sum / 2 + 1];

        if (sum % 2 != 0)
            return false;

        else {
            sum = sum / 2;
            for (int i = 0; i <= n; i++) {
                t[i][0] = true;
            }
            for (int j = 1; j <= sum; j++) {
                t[0][j] = false;
            }

            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < sum + 1; j++) {
                    if (arr[i - 1] <= j) {
                        t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                    } else if (arr[i - 1] > j) {
                        t[i][j] = t[i - 1][j];
                    }
                }
            }
        }
        return t[n][sum];

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(equalSum(arr));

    }
}