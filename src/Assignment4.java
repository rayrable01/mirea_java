import java.util.Date;
import java.util.Calendar;
import java.util.Scanner;
import java.util.GregorianCalendar;

public class Assignment4 {
    public static void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Задание 4 ===");

        // Ввод даты
        System.out.println("Введите дату:");
        System.out.print("Год: ");
        int year = scanner.nextInt();
        System.out.print("Месяц (1-12): ");
        int month = scanner.nextInt();
        System.out.print("Число: ");
        int day = scanner.nextInt();

        // Ввод времени
        System.out.println("\nВведите время:");
        System.out.print("Часы (0-23): ");
        int hours = scanner.nextInt();
        System.out.print("Минуты (0-59): ");
        int minutes = scanner.nextInt();

        // Создание объекта Date
        // Месяц в Date начинается с 0 (январь = 0)
        Date dateObj = new Date(year - 1900, month - 1, day, hours, minutes);

        // Создание объекта Calendar
        Calendar calendarObj = new GregorianCalendar(year, month - 1, day, hours, minutes);

        // Вывод результатов
        System.out.println("\n=== Созданные объекты ===");
        System.out.println("1. Объект Date:");
        System.out.println("   Дата: " + dateObj);
        System.out.println("   Форматированно: " +
                String.format("%02d.%02d.%d %02d:%02d",
                        dateObj.getDate(),
                        dateObj.getMonth() + 1,
                        dateObj.getYear() + 1900,
                        dateObj.getHours(),
                        dateObj.getMinutes()));

        System.out.println("\n2. Объект Calendar:");
        System.out.println("   Дата: " + calendarObj.getTime());
        System.out.println("   Год: " + calendarObj.get(Calendar.YEAR));
        System.out.println("   Месяц: " + (calendarObj.get(Calendar.MONTH) + 1));
        System.out.println("   День: " + calendarObj.get(Calendar.DAY_OF_MONTH));
        System.out.println("   Часы: " + calendarObj.get(Calendar.HOUR_OF_DAY));
        System.out.println("   Минуты: " + calendarObj.get(Calendar.MINUTE));

        scanner.close();
    }
}