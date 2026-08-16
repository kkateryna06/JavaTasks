package day03.task3;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class StudentRegistry {
    private final Set<Student> students;

    StudentRegistry() {
        this.students = new HashSet<>();
    }

    public boolean addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student can't be null");
        }
        return students.add(student);
    }

    public boolean contains(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student can't be null");
        }
        return students.contains(student);
    }

    public boolean remove(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student can't be null");
        }
        return students.remove(student);
    }

    public Student findById(long id) {
        if (id < 1) {
            throw new IllegalArgumentException("Id must be greater than 0");
        }
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        throw new NoSuchElementException("Value not found");
    }

    public int getStudentCount() {
        return students.size();
    }

    public Set<Student> getAllStudents() {
        return new HashSet<>(students);
    }
}
