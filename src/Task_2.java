import java.util.Scanner;

public class Task_2 {
    private int[] array;
    private int arraySize;
    private int counter = 0;
    private int sum = 0;
    Scanner scanner = new Scanner(System.in);

    public void SecondTaskRunner() {
        System.out.println("Введите размер массива: ");
        arraySize = scanner.nextInt();
        array = new int[arraySize];

        FillArray(); // Заполняем массив

        MaxMinFinder();

        System.out.println("Сумма элементов: " + sum);
    }

    public void FillArray() {

        System.out.println("Заполнение чисел массива: ");

        while (arraySize != counter) {
            System.out.println("Введите " + counter + " элемент массива: ");
            int userNumber = scanner.nextInt();

            array[counter] = userNumber;
            sum += userNumber;

            counter++;
        }
    }

    public void MaxMinFinder() {
        int maxNumber = array[0];
        int minNumber = array[0];

        for (int number: array) {
            if (number > maxNumber) {
                maxNumber = number;
            };

            if (number < minNumber) {
                minNumber = number;
            };
        }

        System.out.println("Максимальный элемент массива: " + maxNumber);
        System.out.println("Минимальный элемент массива: " + minNumber);
    }
}
