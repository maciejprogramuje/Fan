package com.facebook.maciejprogramuje;

import java.lang.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        WingedFanPrinter fanPrinter = WingedFanPrinterFactory.getWingedFanPrinter(FanPrinterType.QuadrupleSymmetry);

        Scanner scanner = new Scanner(System.in);
        int fanSize;
        FanDirection fanDirection = null;
        while (true) {
            fanSize = Integer.parseInt(scanner.nextLine());
            if (fanSize > 0) {
                fanDirection = FanDirection.Clockwise;
            } else if (fanSize < 0) {
                fanDirection = FanDirection.CounterClockwise;
            } else {
                System.exit(0);
            }

            fanPrinter.printFan(Math.abs(fanSize), fanDirection);
        }
    }
}

class WingedFanPrinterFactory {
    static WingedFanPrinter getWingedFanPrinter(FanPrinterType fanPrinterType) {
        switch (fanPrinterType) {
            case QuadrupleSymmetry:
                return new WingedFanPrinter();
            default:
                throw new IllegalArgumentException();
        }
    }
}

class WingPainter {
    private int i;

    WingPainter(int i) {
        this.i = i;
    }

    List<String> flipHorizontally(List<String> baseTriangle) {
        List<String> triangle = new ArrayList<>();
        for (int j = i - 1; j >= 0; j--) {
            triangle.add(baseTriangle.get(j));
        }
        return triangle;
    }

    List<String> flipVertically(List<String> baseTriangle) {
        List<String> triangle = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            triangle.add(new StringBuilder(baseTriangle.get(j)).reverse().toString());
        }
        return triangle;
    }

    List<String> generateBaseTriangle() {
        List<String> triangle = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int k = 0; k < i; k++) {
                if (k <= j) {
                    stringBuilder.append("*");
                } else {
                    stringBuilder.append(".");
                }
            }
            triangle.add(stringBuilder.toString());
        }
        return triangle;
    }
}

class WingedFanPrinter {
    private List<String> firstQuaterWing;
    private List<String> secondQuaterWing;
    private List<String> thirdQuaterWing;
    private List<String> fourthQuaterWing;

    WingedFanPrinter() {
        firstQuaterWing = new ArrayList<>();
        secondQuaterWing = new ArrayList<>();
        thirdQuaterWing = new ArrayList<>();
        fourthQuaterWing = new ArrayList<>();
    }

    void printFan(int i, FanDirection fanDirection) {
        WingPainter wingPainter = new WingPainter(i);

        switch (fanDirection) {
            case Clockwise:
                secondQuaterWing = wingPainter.generateBaseTriangle();
                firstQuaterWing = wingPainter.flipHorizontally(secondQuaterWing);
                thirdQuaterWing = wingPainter.flipVertically(secondQuaterWing);
                fourthQuaterWing = wingPainter.flipVertically(firstQuaterWing);
                break;
            case CounterClockwise:
                fourthQuaterWing = wingPainter.generateBaseTriangle();
                firstQuaterWing = wingPainter.flipVertically(fourthQuaterWing);
                secondQuaterWing = wingPainter.flipHorizontally(firstQuaterWing);
                thirdQuaterWing = wingPainter.flipHorizontally(fourthQuaterWing);
                break;
            default:
                //todo = exception
        }

        for (int j = 0; j < i; j++) {
            System.out.println(secondQuaterWing.get(j) + firstQuaterWing.get(j));
        }
        for (int j = 0; j < i; j++) {
            System.out.println(thirdQuaterWing.get(j) + fourthQuaterWing.get(j));
        }
        System.out.println();
    }
}

enum FanDirection {
    Clockwise,
    CounterClockwise
}

enum FanPrinterType {
    QuadrupleSymmetry
}