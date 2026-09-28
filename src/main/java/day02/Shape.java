package day02;

public abstract class Shape {
    private String color;

    Shape(String color) {
        if (color != null && !color.isBlank()) {
            this.color = color;
        } else {
            throw new IllegalArgumentException("Color can't be null or blank");
        }
    }

    public String getColor() {
        return color;
    }

    public abstract double calculateArea();

    public void printInfo() {
        System.out.println("The color of the shape is " + color + ". The area is " + calculateArea());
    }
}
