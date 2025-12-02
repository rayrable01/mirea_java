import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Java Date & Time Project ===");
        System.out.println("Выберите задание для выполнения:");
        System.out.println("1 - Задание 1 (Информация о разработчике)");
        System.out.println("2 - Задание 2 (Сравнение дат)");
        System.out.println("3 - Задание 3 (Класс Student)");
        System.out.println("4 - Задание 4 (Создание Date и Calendar)");
        System.out.println("5 - Задание 5 (Сравнение ArrayList и LinkedList)");
        System.out.print("Ваш выбор: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                Assignment1.execute();
                break;
            case 2:
                Assignment2.execute();
                break;
            case 3:
                testStudent();
                break;
            case 4:
                Assignment4.execute();
                break;
            case 5:
                Assignment5.execute();
                break;
            default:
                System.out.println("Неверный выбор!");
        }

        scanner.close();
    }

    private static void testStudent() {
        Student student = new Student("Гнатюк Даниил Александрович", "2004-08-18");
        System.out.println("Информация о студенте:");
        System.out.println(student);

        System.out.println("\nФорматы даты рождения:");
        System.out.println("Короткий: " + student.getFormattedBirthDate("short"));
        System.out.println("Средний: " + student.getFormattedBirthDate("medium"));
        System.out.println("Полный: " + student.getFormattedBirthDate("full"));
        System.out.println("Свой формат (dd.MM.yyyy): " + student.getFormattedBirthDate("dd.MM.yyyy"));
    }
}