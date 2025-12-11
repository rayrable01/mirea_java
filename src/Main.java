import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileHandler fileHandler = new FileHandler("data.txt");

        try {
            System.out.println("1. Введите текст для записи в файл:");
            String input = scanner.nextLine();
            fileHandler.writeToFile(input);

            System.out.println("\n2. Содержимое файла:");
            System.out.println(fileHandler.readFromFile());

            System.out.println("3. Введите текст для замены в файле:");
            String replaceText = scanner.nextLine();
            fileHandler.replaceInFile(replaceText);
            System.out.println("\nФайл после замены:");
            System.out.println(fileHandler.readFromFile());

            System.out.println("4. Введите текст для добавления в конец файла:");
            String appendText = scanner.nextLine();
            fileHandler.appendToFile(appendText);
            System.out.println("\nФайл после добавления:");
            System.out.println(fileHandler.readFromFile());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
