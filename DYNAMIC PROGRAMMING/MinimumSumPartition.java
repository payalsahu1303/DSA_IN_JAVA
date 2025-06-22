import java.lang.*;
import java.util.*;

class MinimumSumPartition {

    static int minDifference(int arr[]) {
        int n = arr.length, sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        boolean[][] t = new boolean[n + 1][sum + 1];
        Vector<Integer> v = new Vector<>(sum + 1);
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {
            t[i][0] = true;
        }
        for (int j = 1; j <= sum; j++) {
            t[0][j] = false;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        for (int j = 0; j <= sum / 2; j++) {
            if (t[n][j] == true) {
                v.add(j);
            }
        }

        for (int i = 0; i < v.size(); i++) {
            minDiff = Math.min(minDiff, sum - 2 * v.get(i));
        }

        return minDiff;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(minDifference(arr));
    }
}
