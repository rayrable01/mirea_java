import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Assignment5 {
    private static final int TEST_SIZE = 100000;
    private static final int WARMUP_COUNT = 5;
    private static final Random random = new Random();

    public static void execute() {
        System.out.println("=== Задание 5 ===");
        System.out.println("Сравнение производительности ArrayList и LinkedList");
        System.out.println("Размер тестовой коллекции: " + TEST_SIZE + " элементов");
        System.out.println();

        // Разогрев JVM
        for (int i = 0; i < WARMUP_COUNT; i++) {
            warmUp();
        }

        // Тестирование операций
        testAddToEnd();
        testAddToBeginning();
        testAddToMiddle();
        testRemoveFromEnd();
        testRemoveFromBeginning();
        testRemoveFromMiddle();
        testGetByIndex();
        testSearch();
    }

    private static void warmUp() {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < 10000; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }
    }

    private static void testAddToEnd() {
        System.out.println("1. Добавление в конец:");

        List<Integer> arrayList = new ArrayList<>();
        long startTime = System.nanoTime();
        for (int i = 0; i < TEST_SIZE; i++) {
            arrayList.add(i);
        }
        long arrayListTime = System.nanoTime() - startTime;

        List<Integer> linkedList = new LinkedList<>();
        startTime = System.nanoTime();
        for (int i = 0; i < TEST_SIZE; i++) {
            linkedList.add(i);
        }
        long linkedListTime = System.nanoTime() - startTime;

        printResults(arrayListTime, linkedListTime);
    }

    private static void testAddToBeginning() {
        System.out.println("\n2. Добавление в начало:");

        List<Integer> arrayList = new ArrayList<>();
        long startTime = System.nanoTime();
        for (int i = 0; i < TEST_SIZE / 10; i++) { // Меньше элементов из-за сложности O(n)
            arrayList.add(0, i);
        }
        long arrayListTime = System.nanoTime() - startTime;

        List<Integer> linkedList = new LinkedList<>();
        startTime = System.nanoTime();
        for (int i = 0; i < TEST_SIZE / 10; i++) {
            linkedList.add(0, i);
        }
        long linkedListTime = System.nanoTime() - startTime;

        printResults(arrayListTime, linkedListTime);
    }

    private static void testAddToMiddle() {
        System.out.println("\n3. Добавление в середину:");

        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < TEST_SIZE / 2; i++) {
            arrayList.add(i);
        }

        long startTime = System.nanoTime();
        for (int i = 0; i < TEST_SIZE / 100; i++) {
            arrayList.add(arrayList.size() / 2, i);
        }
        long arrayListTime = System.nanoTime() - startTime;

        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < TEST_SIZE / 2; i++) {
            linkedList.add(i);
        }

        startTime = System.nanoTime();
        for (int i = 0; i < TEST_SIZE / 100; i++) {
            linkedList.add(linkedList.size() / 2, i);
        }
        long linkedListTime = System.nanoTime() - startTime;

        printResults(arrayListTime, linkedListTime);
    }

    private static void testRemoveFromEnd() {
        System.out.println("\n4. Удаление с конца:");

        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < TEST_SIZE; i++) {
            arrayList.add(i);
        }

        long startTime = System.nanoTime();
        for (int i = 0; i < TEST_SIZE / 10; i++) {
            arrayList.remove(arrayList.size() - 1);
        }
        long arrayListTime = System.nanoTime() - startTime;

        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < TEST_SIZE; i++) {
            linkedList.add(i);
        }

        startTime = System.nanoTime();
        for (int i = 0; i < TEST_SIZE / 10; i++) {
            linkedList.remove(linkedList.size() - 1);
        }
        long linkedListTime = System.nanoTime() - startTime;

        printResults(arrayListTime, linkedListTime);
    }

    private static void testRemoveFromBeginning() {
        System.out.println("\n5. Удаление с начала:");

        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < TEST_SIZE / 10; i++) {
            arrayList.add(i);
        }

        long startTime = System.nanoTime();
        while (!arrayList.isEmpty()) {
            arrayList.remove(0);
        }
        long arrayListTime = System.nanoTime() - startTime;

        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < TEST_SIZE / 10; i++) {
            linkedList.add(i);
        }

        startTime = System.nanoTime();
        while (!linkedList.isEmpty()) {
            linkedList.remove(0);
        }
        long linkedListTime = System.nanoTime() - startTime;

        printResults(arrayListTime, linkedListTime);
    }

    private static void testRemoveFromMiddle() {
        System.out.println("\n6. Удаление из середины:");

        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < TEST_SIZE / 5; i++) {
            arrayList.add(i);
        }

        long startTime = System.nanoTime();
        for (int i = 0; i < TEST_SIZE / 100; i++) {
            arrayList.remove(arrayList.size() / 2);
        }
        long arrayListTime = System.nanoTime() - startTime;

        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < TEST_SIZE / 5; i++) {
            linkedList.add(i);
        }

        startTime = System.nanoTime();
        for (int i = 0; i < TEST_SIZE / 100; i++) {
            linkedList.remove(linkedList.size() / 2);
        }
        long linkedListTime = System.nanoTime() - startTime;

        printResults(arrayListTime, linkedListTime);
    }

    private static void testGetByIndex() {
        System.out.println("\n7. Получение по индексу (случайный доступ):");

        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < TEST_SIZE; i++) {
            arrayList.add(i);
        }

        long startTime = System.nanoTime();
        for (int i = 0; i < TEST_SIZE / 100; i++) {
            int index = random.nextInt(arrayList.size());
            arrayList.get(index);
        }
        long arrayListTime = System.nanoTime() - startTime;

        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < TEST_SIZE; i++) {
            linkedList.add(i);
        }

        startTime = System.nanoTime();
        for (int i = 0; i < TEST_SIZE / 100; i++) {
            int index = random.nextInt(linkedList.size());
            linkedList.get(index);
        }
        long linkedListTime = System.nanoTime() - startTime;

        printResults(arrayListTime, linkedListTime);
    }

    private static void testSearch() {
        System.out.println("\n8. Поиск элемента (indexOf):");

        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < TEST_SIZE; i++) {
            arrayList.add(i);
        }

        long startTime = System.nanoTime();
        for (int i = 0; i < TEST_SIZE / 100; i++) {
            int searchValue = random.nextInt(TEST_SIZE * 2);
            arrayList.indexOf(searchValue);
        }
        long arrayListTime = System.nanoTime() - startTime;

        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < TEST_SIZE; i++) {
            linkedList.add(i);
        }

        startTime = System.nanoTime();
        for (int i = 0; i < TEST_SIZE / 100; i++) {
            int searchValue = random.nextInt(TEST_SIZE * 2);
            linkedList.indexOf(searchValue);
        }
        long linkedListTime = System.nanoTime() - startTime;

        printResults(arrayListTime, linkedListTime);
    }

    private static void printResults(long arrayListTime, long linkedListTime) {
        System.out.printf("   ArrayList:  %,.3f ms%n", arrayListTime / 1_000_000.0);
        System.out.printf("   LinkedList: %,.3f ms%n", linkedListTime / 1_000_000.0);

        if (arrayListTime < linkedListTime) {
            double faster = (linkedListTime - arrayListTime) * 100.0 / linkedListTime;
            System.out.printf("   ArrayList быстрее на %.1f%%%n", faster);
        } else {
            double faster = (arrayListTime - linkedListTime) * 100.0 / arrayListTime;
            System.out.printf("   LinkedList быстрее на %.1f%%%n", faster);
        }
    }
}