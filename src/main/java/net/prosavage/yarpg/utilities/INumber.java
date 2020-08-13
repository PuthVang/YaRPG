package net.prosavage.yarpg.utilities;

import java.util.Random;

public class INumber{

    public INumber(){}

    public static Double getDouble(Double min, Double max)
    {
        Random r = new Random();
        return Double.parseDouble(String.valueOf((min + (max - min) * r.nextDouble())));
    }

    public static Integer getInteger(Integer min, Integer max)
    {
        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }

    public static int floor(double number){
        return Integer.parseInt(String.valueOf(Math.floor(number)));
    }

    public static boolean isNumeric(String strNum) {
        return strNum.matches("-?\\d+(\\.\\d+)?");
    }

    public static boolean isParsableAsDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
    }

    public static boolean isParsableAsInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
    }

}