package com.facebook.maciejprogramuje;


public class WingedFanPrinterFactory {
    public static WingedFanPrinter getWingedFanPrinter(FanPrinterType fanPrinterType) {
        switch (fanPrinterType) {
            case QuadrupleSymmetry:
                return new WingedFanPrinter();
            default:
                throw new IllegalArgumentException();
        }
    }
}
