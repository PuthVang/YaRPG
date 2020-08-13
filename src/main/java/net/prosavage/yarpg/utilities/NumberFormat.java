package net.prosavage.yarpg.utilities;

import java.text.DecimalFormat;

public class NumberFormat {

    private static final DecimalFormat doubleFormat = new DecimalFormat("##.##");

    public NumberFormat(){}

    public static DecimalFormat getDoubleFormat() {
        return doubleFormat;
    }
}
