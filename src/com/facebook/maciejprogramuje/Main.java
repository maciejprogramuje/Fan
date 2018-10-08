package com.facebook.maciejprogramuje;

import java.lang.*;

class Main {
    public static void main (String[] args)
    {
        WingedFanPrinter fanPrinter = WingedFanPrinterFactory.getWingedFanPrinter(FanPrinterType.QuadrupleSymmetry);
        fanPrinter.printFan(14, FanDirection.Clockwise);
    }
}