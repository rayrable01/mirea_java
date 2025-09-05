import java.util.Scanner;

public class Task_5 {
    private Scanner scanner = new Scanner(System.in);

    public void task5Runner() {
        System.out.println("Введите число для подсчета факториала: ");
        int userValue = scanner.nextInt();

        int value = factorialCalculator(userValue);
        System.out.println("Факториал " + userValue + " = " + value);
    }

    public int factorialCalculator(int number) {
        if (number < 0) {
            System.out.println("Невозможно посчитать факториал отрицательного числа!");
            return -1;
        }

        int factorialValue = 1;
        for (int i = 1; i <= number; i++) {
            factorialValue *= i;
        }

        return factorialValue;
    }
}
