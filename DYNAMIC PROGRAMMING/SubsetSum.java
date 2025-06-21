import java.util.*;

public class SubsetSum {
  static boolean subset(int[] arr, int sum) {
    int n = arr.length;
    boolean[][] t = new boolean[n + 1][sum + 1];
    for (int j = 1; j <= sum; j++) {
      t[0][j] = false;
    }
    for (int i = 0; i <= n; i++) {
      t[i][0] = true;
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
    return t[n][sum];
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    int sum = sc.nextInt();

    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    System.out.println(subset(arr, sum));

  }
}
