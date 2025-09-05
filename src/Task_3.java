public class Task_3 {

    public void task3Runner(String[] arguments) {
        System.out.println("Аргументы командной строки: ");

        if (arguments.length == 0) {
            System.out.println("Отсутствуют аргументы!");
            return;
        }

        for (int i = 0; i < arguments.length; i++) {
            System.out.println("Аргумент " + i + ": " + arguments[i]);
        }
    }
}
