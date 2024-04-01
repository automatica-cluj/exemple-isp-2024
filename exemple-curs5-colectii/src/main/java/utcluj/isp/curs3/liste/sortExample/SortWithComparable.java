package utcluj.isp.curs3.liste.sortExample;

public class SortWithComparable {
    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student("John", 10);
        students[1] = new Student("Alice", 8);
        students[2] = new Student("Bob", 9);

        System.out.println("Before sorting:");
        for (Student student : students) {
            System.out.println(student);
        }

        java.util.Arrays.sort(students);
        System.out.println("After sorting:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

class Student implements Comparable<Student> {
    private String name;
    private int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }


    /**
     * Compares this object with the specified object for order.
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(Student o) {
        return this.grade - o.grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
