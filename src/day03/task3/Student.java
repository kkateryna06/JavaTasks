package day03.task3;

import java.util.Objects;

public class Student {
    private final long id;
    private String name;

    Student(long id, String name) {
        if (id < 1) {
            throw new IllegalArgumentException("Id must be greater than 0");
        } else if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name can't be null or blank");
        }
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void rename(String newName) {
        if (newName == null || newName.isBlank()) {
            throw new IllegalArgumentException("Name can't be null or blank");
        }
        name = newName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof Student student)) {
            return false;
        }

        return student.id == this.id;
    }

    @Override
    public String toString() {
        return id + ". " + name;
    }
}
