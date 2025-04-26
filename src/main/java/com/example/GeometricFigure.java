package com.example;

import java.io.Serializable;

public abstract class GeometricFigure implements Serializable {

    public abstract double calculateArea();
    public abstract double calculatePerimeter();
    public abstract String toString();
}
