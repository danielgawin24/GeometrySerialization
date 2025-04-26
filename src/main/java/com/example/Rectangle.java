package com.example;

public class Rectangle extends GeometricFigure {
    private double height, width;

    public Rectangle(double a, double b) {
        this.height = a;
        this.width = b;
    }

    @Override
    public double calculateArea() {
        return height * width;
    }

    @Override
    public double calculatePerimeter() {
        return (2 * height) + (2 * width);
    }

    @Override
    public String toString() {
        return "Rectangle, height = " + height + ", width = " + width +
                ", area = " + calculateArea() + ", perimeter = " + calculatePerimeter();
    }
}
