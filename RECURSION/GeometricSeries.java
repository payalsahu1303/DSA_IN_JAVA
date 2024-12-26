// Find the nth term of the geometric progression using recursion.

public class GeometricSeries {
    static float geometric(float firstTerm, float difference, int nthTerm) {
        if (nthTerm == 1) {
            return firstTerm;
        }
        return difference * geometric(firstTerm, difference, nthTerm - 1);
    }

    public static void main(String[] args) {
        float r = 2, a = 1;
        int n = 7;
        System.out.println(n + "th term is " + geometric(a, r, n));
    }
}

// Time complexity is O(n) (linear recursion). Space complexity is O(n)
// (recursion stack for n calls).
