package com.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FiguresList {

    private List<GeometricFigure> figures;

    public FiguresList() {
        figures = new ArrayList<>();
    }

    public void addFigure(GeometricFigure figure) {
        figures.add(figure);
    }

    public void printFigures() {
        if (figures.isEmpty()) {
            System.out.println("Empty figure list");
        }
        for (GeometricFigure figure : figures) {
            System.out.println(figure);
        }
    }

    public void serialize(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(figures);
            System.out.println("Serialized " + figures.size() + " figures to file: '" + fileName + "'");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public void deserialize(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            figures = (List<GeometricFigure>) ois.readObject();
            System.out.println("Deserialized " + figures.size() + " figures from file: '" + fileName + "'");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
