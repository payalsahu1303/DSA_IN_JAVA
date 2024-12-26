// Print all subsets of an array using recursion. Total no. of subsets are 2^n.

import java.util.ArrayList;
import java.util.List;

public class SubsetOfArray {
    static void subArrays(int[] arr, int id, List<Integer> curr) {
        if (id == arr.length) {
            System.out.println(curr);
            return;
        }
        subArrays(arr, id + 1, curr);
        curr.add(arr[id]);

        subArrays(arr, id + 1, curr);
        curr.remove(curr.size() - 1);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        subArrays(arr, 0, new ArrayList<>());
    }
}

// Time Complexity is O(2^n) as Recursive calls for all subsets. Space
// Complexity is O(n) as Recursive stack depth proportional to array size.