package com.example;

public class Triangle extends GeometricFigure {
    private double a, b, c;
    private double height;

    public Triangle(double a, double height) {
        this.a = a;
        this.height = height;
    }

    public Triangle(double a, double b, double c, double height) {
        if (a <= 0 || b <= 0 || c <= 0 || height <= 0) {
            throw new IllegalArgumentException("Height and sides must be greater than 0");
        }
        this.a = a;
        this.b = b;
        this.c = c;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5d * a * height;
    }

    @Override
    public double calculatePerimeter() {
        return a + b + c;
    }

    @Override
    public String toString() {
        return "Triangle, a = " + a + ", b = " + b + ", c = " + c +
                ", height = " + height + ", area = " + calculateArea() + ", perimeter = " + calculatePerimeter();
    }
}
