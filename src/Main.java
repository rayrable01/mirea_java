public class Main {
    public static void main(String[] args) {
        System.out.println("Начало выполнения заданий...");
        // TASK 1
        System.out.println("Задание 1");
        Task_1 task1 = new Task_1();
        task1.firstTaskRunner();

        // TASK 2
        System.out.println("Задание 2");
        Task_2 task2 = new Task_2();
        task2.SecondTaskRunner();

        // TASK 3
        System.out.println("Задание 3");
        Task_3 task3 = new Task_3();
        task3.task3Runner(args);

        // TASK 4
        System.out.println("Задание 4");
        Task_4 task4 = new Task_4();
        task4.task4Runner();

        // TASK 5
        System.out.println("Задание 5");
        Task_5 task5 = new Task_5();
        task5.task5Runner();
    }
}