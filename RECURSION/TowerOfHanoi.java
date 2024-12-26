// Tower of Hanoi using Recursion:
// The idea is to use the helper node to reach the destination using recursion. Below is the pattern for this problem:
// - Shift ‘N-1’ disks from ‘A’ to ‘B’, using C.
// - Shift last disk from ‘A’ to ‘C’.
// - Shift ‘N-1’ disks from ‘B’ to ‘C’, using A.
// - Total no. of moves will be 2^n - 1.

public class TowerOfHanoi {

    static void towerOfHanoi(int n, char source, char destination, char helper) {
        if (n <= 0) {
            return;
        } else {
            towerOfHanoi(n - 1, source, helper, destination);
            System.out.println("Move disk " + n + " from rod " + source + " to rode " + destination);
            towerOfHanoi(n - 1, helper, destination, source);
        }
    }

    public static void main(String[] args) {
        int n = 4;
        towerOfHanoi(n, 'A', 'C', 'B');
    }
}

// Time Complexity is O(2^n) due to recursive calls. Space Complexity: is O(n)
// for recursion stack.