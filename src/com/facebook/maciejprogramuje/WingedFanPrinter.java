package com.facebook.maciejprogramuje;

import java.util.ArrayList;
import java.util.List;

class WingedFanPrinter {
    private List<String> firstQuaterLines;
    private List<String> secondQuaterLines;
    private List<String> thirdQuaterLines;
    private List<String> fourthQuaterLines;
    private int i;

    WingedFanPrinter() {
        firstQuaterLines = new ArrayList<>();
        secondQuaterLines = new ArrayList<>();
        thirdQuaterLines = new ArrayList<>();
        fourthQuaterLines = new ArrayList<>();
    }

    void printFan(int i, FanDirection fanDirection) {
        this.i = i;

        switch (fanDirection) {
            case Clockwise:
                bTriangle(secondQuaterLines);
                aTriangle(firstQuaterLines, secondQuaterLines);
                rotate180(thirdQuaterLines, secondQuaterLines);
                rotate180(fourthQuaterLines, firstQuaterLines);
                break;
            case CounterClockwise:

                break;
            default:
                //todo = exception
        }

        for (int j = 0; j < i; j++) {
            System.out.println(secondQuaterLines.get(j) + firstQuaterLines.get(j));
        }
        for (int j = 0; j < i; j++) {
            System.out.println(thirdQuaterLines.get(j) + fourthQuaterLines.get(j));
        }
    }

    private void bTriangle(List<String> quaterToFill) {
        for (int j = 0; j < i; j++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int k = 0; k < i; k++) {
                if (k <= j) {
                    stringBuilder.append("*");
                } else {
                    stringBuilder.append(".");
                }
            }
            quaterToFill.add(stringBuilder.toString());
        }
    }

    private void aTriangle(List<String> quaterToFill, List<String> baseQuater) {
        for (int j = i - 1; j >= 0; j--) {
            quaterToFill.add(baseQuater.get(j));
        }
    }

    private void rotate180(List<String> quaterToFill, List<String> baseQuater) {
        for (int j = 0; j < i; j++) {
            quaterToFill.add(new StringBuilder(baseQuater.get(j)).reverse().toString());
        }
    }
}
