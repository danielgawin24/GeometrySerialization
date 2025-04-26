package com.example;

public class Circle extends GeometricFigure {
    private double radius;
    private final double PI = Math.PI;

    public Circle(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative");
        }
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * PI * radius;
    }

    @Override
    public String toString() {
        return "Circle radius = " + radius + ", area = " + calculateArea() +
                ", perimeter = " + calculatePerimeter();
    }
}
