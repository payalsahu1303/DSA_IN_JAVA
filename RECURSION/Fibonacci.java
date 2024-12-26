// Generate the Fibonacci sequence up to n.

public class Fibonacci {
    static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        int n = 7;
        for (int i = 0; i < n; i++) {
            System.out.print(fib(i) + " ");
        }

    }
}

// Time complexity is O(2^n) (exponential due to recursion), Space complexity is
// O(n) (stack space for recursive calls).