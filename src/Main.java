import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int size = 100_000;
        int[] arr = new int[size];

        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt();
        }

        StopWatch sw = new StopWatch();
        sw.start();

        selectionSort(arr);

        sw.stop();

        System.out.println("Время сортировки выбором: " + sw.getElapsedTime() + " ms");
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
