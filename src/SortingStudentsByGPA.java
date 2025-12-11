import java.util.Comparator;

public class SortingStudentsByGPA implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Double.compare(s2.getGpa(), s1.getGpa());
    }

    public static void quickSort(Student[] arr, int low, int high, Comparator<Student> comp) {
        if (low < high) {
            int pi = partition(arr, low, high, comp);
            quickSort(arr, low, pi - 1, comp);
            quickSort(arr, pi + 1, high, comp);
        }
    }

    private static int partition(Student[] arr, int low, int high, Comparator<Student> comp) {
        Student pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (comp.compare(arr[j], pivot) < 0) {
                i++;
                Student temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Student temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
