package day02;

public class Circle extends Shape {
    private double radius;
    Circle(String color, double radius) {
        super(color);
        if (radius > 0) {
            this.radius = radius;
        } else {
            throw new IllegalArgumentException("Radius must be positive");
        }
    }

    @Override
    public double calculateArea() {
        return Math.pow(radius, 2) * Math.PI;
    }
}
