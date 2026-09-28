package day03.task3;

import java.util.NoSuchElementException;

public class Task3 {
    public static void main(String[] args) {
        Student first = new Student(1, "Kate");
        Student second = new Student(1, "Anna");
        Student third = new Student(2, "Tom");

        StudentRegistry studentRegistry = new StudentRegistry();

        // add students
        System.out.println(studentRegistry.addStudent(first));
        System.out.println(studentRegistry.addStudent(second));
        System.out.println(studentRegistry.addStudent(third));

        // contains
        System.out.println(studentRegistry.contains(first));
        try {
            studentRegistry.contains(null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // remove
        studentRegistry.remove(first);
        System.out.println(studentRegistry.getAllStudents());
        try {
            studentRegistry.remove(null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // find by id
        System.out.println(studentRegistry.findById(2));
        try {
            studentRegistry.findById(-1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            studentRegistry.findById(100);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        // get count
        System.out.println(studentRegistry.getStudentCount());

        // equals & hashcode
        System.out.println(first.equals(second));
        System.out.println(first.hashCode() == second.hashCode());

        // rename
        studentRegistry.addStudent(first);
        first.rename("Mia");
        System.out.println(studentRegistry.getAllStudents());

        // get all students
        studentRegistry.getAllStudents().clear();
        System.out.println(studentRegistry.getAllStudents());
    }
}
