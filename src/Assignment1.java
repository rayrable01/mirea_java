import java.util.Date;
import java.text.SimpleDateFormat;

public class Assignment1 {
    public static void execute() {
        // Дата и время получения задания (фиксированная)
        Date assignmentReceived = new Date(124, 10, 20, 10, 0, 0); // 20 ноября 2024, 10:00:00

        // Текущая дата и время (сдача задания)
        Date assignmentSubmitted = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        System.out.println("=== Задание 1 ===");
        System.out.println("Фамилия разработчика: Гнатюк");
        System.out.println("Дата и время получения задания: " + dateFormat.format(assignmentReceived));
        System.out.println("Дата и время сдачи задания: " + dateFormat.format(assignmentSubmitted));
        System.out.println("Текущее время в миллисекундах: " + System.currentTimeMillis());
    }
}