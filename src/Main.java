public class Main {
    public static void main(String[] args) {

        System.out.println("Задание 7: Разложение на множители");
        Factorization.factor(360);
        System.out.println("\n");

        System.out.println("Задание 8: Палиндром");
        System.out.println(Palindrome.isPalindrome("madam") ? "YES" : "NO");
        System.out.println(Palindrome.isPalindrome("hello") ? "YES" : "NO");
        System.out.println();

        System.out.println("Задание 9: Без двух нулей");
        System.out.println(NoTwoZeros.count(2, 3));
        System.out.println(NoTwoZeros.count(3, 3));
        System.out.println();

        System.out.println("Задание 10: Разворот числа");
        System.out.println(ReverseNumber.reverse(12345));
        System.out.println(ReverseNumber.reverse(987654321));
    }
}
