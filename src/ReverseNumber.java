public class ReverseNumber {

    public static long reverse(long n) {
        return helper(n, digits(n) - 1);
    }

    private static long helper(long n, int p) {
        if (n < 10) return n * pow10(p);
        return (n % 10) * pow10(p) + helper(n / 10, p - 1);
    }

    private static int digits(long n) {
        if (n < 10) return 1;
        return 1 + digits(n / 10);
    }

    private static long pow10(int p) {
        if (p == 0) return 1;
        return 10 * pow10(p - 1);
    }
}
