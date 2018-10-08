package com.facebook.maciejprogramuje;

import java.util.ArrayList;
import java.util.List;

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
    }


}
