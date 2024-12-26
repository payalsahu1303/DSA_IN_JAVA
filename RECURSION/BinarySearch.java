// Performed binary search recursively.

import java.util.Arrays;

public class BinarySearch {

    static int bSearch(int[] arr, int n, int startId, int endId) {
        int mid = startId + (endId - startId) / 2;
        if (arr[mid] == n) {
            return mid;
        } else if (arr[mid] < n) {
            return bSearch(arr, n, mid + 1, endId);
        } else if (arr[mid] > n) {
            return bSearch(arr, n, startId, mid);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 2, 8, 6, 7, 0, 1 };
        int n = 6;
        Arrays.sort(arr);
        System.out.println(bSearch(arr, n, arr[0], arr[arr.length - 1]));
    }
}

// Time complexity is O(log n), Space complexity is O(log n) due to recursive
// calls (depth of recursion stack).