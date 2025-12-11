public class Factorization {

    public static void factor(long n) {
        factorRec(n, 2);
    }

    private static void factorRec(long n, long d) {
        if (n == 1) return;
        if (d * d > n) {
            System.out.print(n + " ");
            return;
        }
        if (n % d == 0) {
            System.out.print(d + " ");
            factorRec(n / d, d);
        } else {
            factorRec(n, d + 1);
        }
    }
}
