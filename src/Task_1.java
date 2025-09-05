public class Task_1 {
    private final int[] array = {1, 2, 3, 4, -5, 10, 0};
    private int sum;
    private final int arrayLength = array.length;

    public void firstTaskRunner() {
        for (int number: array) {
            sum += number;
        }

        System.out.println("Сумма массива: " + sum);
        System.out.println("Среднее арифметическое: " + sum / arrayLength);
    }
}
