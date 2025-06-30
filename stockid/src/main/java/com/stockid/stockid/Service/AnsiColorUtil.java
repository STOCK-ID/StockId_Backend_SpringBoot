package com.stockid.stockid.Service;


public class AnsiColorUtil {

    private static final String RESET = "\u001B[0m";
    private static final String PURPLE = "\u001B[35m";
    private static final String GREEN = "\u001B[32m";

    public static String colorText(String text, String color) {
        String colorCode;
        
        switch (color.toUpperCase()) {
            case "PURPLE":
                colorCode = PURPLE;
                break;

            case "GREEN":
                colorCode = GREEN;
                break;
        
            default:
                colorCode = RESET;
                break;
        }
        return colorCode + text + RESET;
    }

}
