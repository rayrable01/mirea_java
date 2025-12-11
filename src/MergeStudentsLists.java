import java.util.ArrayList;
import java.util.List;

public class MergeStudentsLists {
    public static List<Student> mergeAndSort(List<Student> list1, List<Student> list2) {
        List<Student> merged = new ArrayList<>(list1);
        merged.addAll(list2);
        return mergeSort(merged);
    }

    private static List<Student> mergeSort(List<Student> list) {
        if (list.size() <= 1) return list;
        int mid = list.size() / 2;
        List<Student> left = mergeSort(list.subList(0, mid));
        List<Student> right = mergeSort(list.subList(mid, list.size()));
        return merge(left, right);
    }

    private static List<Student> merge(List<Student> left, List<Student> right) {
        List<Student> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).getIdNumber() <= right.get(j).getIdNumber()) {
                result.add(left.get(i++));
            } else {
                result.add(right.get(j++));
            }
        }
        while (i < left.size()) result.add(left.get(i++));
        while (j < right.size()) result.add(right.get(j++));
        return result;
    }

    public static void main(String[] args) {
        List<Student> list1 = List.of(
                new Student("Alice", 3, 4.2),
                new Student("Bob", 1, 3.5)
        );
        List<Student> list2 = List.of(
                new Student("Charlie", 2, 3.8),
                new Student("David", 4, 4.0)
        );
        List<Student> merged = mergeAndSort(list1, list2);
        System.out.println(merged);
    }
}
