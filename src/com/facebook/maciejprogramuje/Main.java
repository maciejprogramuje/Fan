package com.facebook.maciejprogramuje;

import java.lang.*;
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