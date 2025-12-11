public class ComparableStudent implements Comparable<ComparableStudent> {
    public String name;
    private int idNumber;
    private double gpa;

    public ComparableStudent(String name, int idNumber, double gpa) {
        this.name = name;
        this.idNumber = idNumber;
        this.gpa = gpa;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public int compareTo(ComparableStudent o) {
        return Integer.compare(this.idNumber, o.idNumber);
    }

    @Override
    public String toString() {
        return "ComparableStudent{" +
                "name='" + name + '\'' +
                ", idNumber=" + idNumber +
                ", gpa=" + gpa +
                '}';
    }

    public static void main(String[] args) {
        ComparableStudent[] students = {
                new ComparableStudent("Alice", 3, 4.2),
                new ComparableStudent("Bob", 1, 3.5),
                new ComparableStudent("Charlie", 2, 3.8)
        };
        java.util.Arrays.sort(students);
        System.out.println(java.util.Arrays.toString(students));
    }
}
