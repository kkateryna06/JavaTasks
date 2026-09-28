package day01;

public class Rectangle {
    private double width;
    private double height;

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    Rectangle(double width, double height) {
        if (width > 0 && height > 0) {
            this.width = width;
            this.height = height;
        } else {
            throw new IllegalArgumentException("Width and height must be positive");
        }
    }

    public void resize(double newWidth, double newHeight) {
        if (newWidth > 0 && newHeight > 0) {
            width = newWidth;
            height = newHeight;
        } else {
            throw new IllegalArgumentException("Width and height must be positive");
        }
    }

    public double calculateArea() {
        return width * height;
    }

    public double calculatePerimeter() {
        return (width * 2) + (height * 2);
    }
}
