public class NoTwoZeros {

    public static long count(int a, int b) {
        return rec(a, b, 1);
    }

    private static long rec(int a, int b, int last) {
        if (a == 0 && b == 0) return 1;
        long res = 0;
        if (b > 0) res += rec(a, b - 1, 1);
        if (a > 0 && last == 1) res += rec(a - 1, b, 0);
        return res;
    }
}
