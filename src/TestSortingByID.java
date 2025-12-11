import java.util.Arrays;

public class TestSortingByID {
    public static void main(String[] args) {
        Student[] students = {
                new Student("Alice", 3, 4.2),
                new Student("Bob", 1, 3.5),
                new Student("Charlie", 2, 3.8)
        };

        for (int i = 1; i < students.length; i++) {
            Student key = students[i];
            int j = i - 1;
            while (j >= 0 && students[j].getIdNumber() > key.getIdNumber()) {
                students[j + 1] = students[j];
                j--;
            }
            students[j + 1] = key;
        }

        System.out.println(Arrays.toString(students));
    }
}
