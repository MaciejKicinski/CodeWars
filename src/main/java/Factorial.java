public class Factorial {

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return (n * factorial(n - 1));
        }
    }

    public static int factorial2(int n) {
        int iloczyn = 1;
        for (int i = 1; i < n; i++) {
            iloczyn *= i;
        }
        return iloczyn;
    }
}
