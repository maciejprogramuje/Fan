package com.facebook.maciejprogramuje;

import java.util.ArrayList;
import java.util.List;

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


