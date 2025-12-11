import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Задание 1: сортировка вставками по id
        Student[] students1 = {
                new Student("Alice", 3, 4.2),
                new Student("Bob", 1, 3.5),
                new Student("Charlie", 2, 3.8)
        };
        for (int i = 1; i < students1.length; i++) {
            Student key = students1[i];
            int j = i - 1;
            while (j >= 0 && students1[j].getIdNumber() > key.getIdNumber()) {
                students1[j + 1] = students1[j];
                j--;
            }
            students1[j + 1] = key;
        }
        System.out.println("Сортировка вставками по ID:");
        printStudents(students1);

        // Задание 2: быстрая сортировка по GPA с Comparator
        Student[] students2 = {
                new Student("Alice", 3, 4.2),
                new Student("Bob", 1, 3.5),
                new Student("Charlie", 2, 3.8)
        };
        SortingStudentsByGPA.quickSort(students2, 0, students2.length - 1, new SortingStudentsByGPA());
        System.out.println("\nБыстрая сортировка по GPA:");
        printStudents(students2);

        // Задание 3: слияние двух списков и сортировка слиянием по ID
        List<Student> list1 = List.of(
                new Student("Alice", 3, 4.2),
                new Student("Bob", 1, 3.5)
        );
        List<Student> list2 = List.of(
                new Student("Charlie", 2, 3.8),
                new Student("David", 4, 4.0)
        );
        List<Student> merged = MergeStudentsLists.mergeAndSort(list1, list2);
        System.out.println("\nСлияние двух списков и сортировка по ID:");
        printStudents(merged);

        // Задание 4: ComparableStudent сортировка по ID
        ComparableStudent[] students3 = {
                new ComparableStudent("Alice", 3, 4.2),
                new ComparableStudent("Bob", 1, 3.5),
                new ComparableStudent("Charlie", 2, 3.8)
        };
        Arrays.sort(students3);
        System.out.println("\nСортировка ComparableStudent по ID:");
        printComparableStudents(students3);
    }

    private static void printStudents(Student[] students) {
        for (Student s : students) {
            System.out.printf("ID: %d, Name: %s, GPA: %.2f%n", s.getIdNumber(), s.getName(), s.getGpa());
        }
    }

    private static void printStudents(List<Student> students) {
        for (Student s : students) {
            System.out.printf("ID: %d, Name: %s, GPA: %.2f%n", s.getIdNumber(), s.getName(), s.getGpa());
        }
    }

    private static void printComparableStudents(ComparableStudent[] students) {
        for (ComparableStudent s : students) {
            System.out.printf("ID: %d, Name: %s, GPA: %.2f%n", s.getIdNumber(), s.name, s.getGpa());
        }
    }
}
