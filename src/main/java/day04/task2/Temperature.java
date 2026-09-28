package day04.task2;

final class Temperature {
    private final int celsius;

    Temperature(int celsius) {
        if (celsius < -273) {
            throw new IllegalArgumentException("Temperature can't be less than -273");
        }
        this.celsius = celsius;
    }

    public int getCelsius() {
        return celsius;
    }

    public Temperature increase(int degrees) {
        if (degrees < 1) {
            throw new IllegalArgumentException("Degrees must be greater than 0");
        }
        return new Temperature(this.celsius + degrees);
    }

    public Temperature decrease(int degrees) {
        if (degrees < 1) {
            throw new IllegalArgumentException("Degrees must be greater than 0");
        }
        return new Temperature(this.celsius - degrees);
    }
}
