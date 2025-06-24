import java.util.Scanner;

public class PartitionsWithGivenDifference {
    static int countPartitions(int[] arr, int d) {
        // code here
        int total = 0, n = arr.length;

        for (int num : arr) {
            total += num;
        }

        int sum = (total + d) / 2;
        if ((d + total) % 2 != 0) {
            return 0;
        }

        int[][] t = new int[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            t[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];
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
        int[] arr = new int[n];
        int d = sc.nextInt();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(countPartitions(arr, d));

    }

}
