package com.example;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final FiguresList figuresList = new FiguresList();

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = numberSelector(1, 5, "Select available option: ");
            switch (choice) {
                case 1:
                    addFigure();
                    break;
                case 2:
                    figuresList.printFigures();
                    break;
                case 3:
                    serialize();
                    break;
                case 4:
                    deserialize();
                    break;
                case 5:
                    System.out.println("End of the program.");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add figure");
        System.out.println("2. Print figures");
        System.out.println("3. Serialize to file");
        System.out.println("4. Deserialize from file");
        System.out.println("5. Exit");
    }

    private static int numberSelector(int from, int to, String message) {
        while (true) {
            System.out.println(message);
            try {
                int num = Integer.parseInt(scanner.nextLine());
                if (num >= from && num <= to) {
                    return num;
                } else {
                    System.out.println("Number must be between " + from + " and " + to);
                }
            } catch (NumberFormatException e) {
                System.out.println("Write a correct number");
            }
        }
    }

    private static double getRequiredDouble(String message) {
        while (true) {
            System.out.print(message);
            try {
                double d = Double.parseDouble(scanner.nextLine());
                if (d > 0) {
                    return d;
                }
                System.out.println("Number must be positive");
            } catch (NumberFormatException e) {
                System.out.println("Number must be correct");
            }
        }
    }

    private static void addFigure() {
        System.out.println("Enter figure number: ");
        System.out.println("1. Circle");
        System.out.println("2. Triangle");
        System.out.println("3. Rectangle");
        int figureNum = numberSelector(1, 3, "Enter figure number: ");

        try {
            switch (figureNum) {
                case 1:
                    double radius = getRequiredDouble("Enter radius: ");
                    figuresList.addFigure(new Circle(radius));
                    System.out.println("Circle added to the list");
                    break;
                case 2:
                    double a = getRequiredDouble("Enter a: ");
                    double b = getRequiredDouble("Enter b: ");
                    double c = getRequiredDouble("Enter c: ");
                    double height = getRequiredDouble("Enter height: ");
                    figuresList.addFigure(new Triangle(a, b, c, height));
                    System.out.println("Triangle added to the list");
                    break;
                case 3:
                    double length = getRequiredDouble("Enter length: ");
                    double width = getRequiredDouble("Enter width: ");
                    figuresList.addFigure(new Rectangle(length, width));
                    System.out.println("Rectangle added to the list");
                    break;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void serialize() {
        System.out.println("Write file name like figures.dat: ");
        String fileName = scanner.nextLine();
        if (fileName.isEmpty()) {
            System.out.println("File name cannot be empty");
            return;
        }
        figuresList.serialize(fileName);
    }

    private static void deserialize() {
        System.out.println("Write file name like figures.dat: ");
        String fileName = scanner.nextLine();
        if (fileName.isEmpty()) {
            System.out.println("File name cannot be empty");
            return;
        }
        figuresList.deserialize(fileName);
    }

}