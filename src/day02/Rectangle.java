package day02;

public class Rectangle extends Shape {
    private double width;
    private double length;

    Rectangle(String color, double width, double length) {
        super(color);
        if (width > 0 && length > 0) {
            this.width = width;
            this.length = length;
        } else {
            throw new IllegalArgumentException("Width and length must be positive");
        }
    }

    @Override
    public double calculateArea() {
        return width * length;
    }
}
