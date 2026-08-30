package day06.task3;

public class Participant implements Comparable<Participant> {
    private final long id;
    private final String name;
    private final int score;
    private final int age;

    Participant(long id, String name, int score, int age) {
        if (id < 1) throw new IllegalArgumentException("Id must be greater than 0");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name can't be null or blank");
        if (score < 0) throw new IllegalArgumentException("Score can't be negative");
        if (age < 0) throw new IllegalArgumentException("Age must be positive");

        this.id = id;
        this.name = name;
        this.score = score;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Participant participant) {
        if (participant == null) throw new IllegalArgumentException("Participant can't be null");

        return Long.compare(this.id, participant.id);
    }
}
