import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Assignment2 {
    public static void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Задание 2 ===");
        System.out.println("Введите дату для сравнения (формат: dd.MM.yyyy):");
        String inputDateStr = scanner.next();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            Date inputDate = dateFormat.parse(inputDateStr);
            Date currentDate = new Date();

            System.out.println("\nТекущая дата: " + dateFormat.format(currentDate));
            System.out.println("Введенная дата: " + dateFormat.format(inputDate));

            // Сравнение дат
            int comparison = inputDate.compareTo(currentDate);

            if (comparison < 0) {
                System.out.println("Введенная дата РАНЬШЕ текущей даты");
            } else if (comparison > 0) {
                System.out.println("Введенная дата ПОЗЖЕ текущей даты");
            } else {
                System.out.println("Даты РАВНЫ");
            }

            // Разница в днях
            long diffInMillies = Math.abs(currentDate.getTime() - inputDate.getTime());
            long diffInDays = diffInMillies / (1000 * 60 * 60 * 24);
            System.out.println("Разница в днях: " + diffInDays + " дней");

        } catch (ParseException e) {
            System.out.println("Ошибка: неверный формат даты!");
        }

        scanner.close();
    }
}