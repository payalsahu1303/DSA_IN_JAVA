// Factorial in Java Using Recursive Method

public class Factorial {
    static int fact(int num) {
        if (num == 0) {
            return 1;
        }
        return num * fact(num - 1);
    }

    public static void main(String[] args) {
        int num = 8;
        System.out.println(fact(num));
    }
}

// Time complexity is O(n) due to `n` recursive calls, and space complexity is
// O(n) for the recursion stack.