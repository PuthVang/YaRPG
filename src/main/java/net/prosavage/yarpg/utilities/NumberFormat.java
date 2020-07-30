package net.prosavage.yarpg.utilities;

import java.text.DecimalFormat;

public class NumberFormat {

    private final DecimalFormat doubleFormat = new DecimalFormat("##.##");

    public DecimalFormat getDoubleFormat() {
        return this.doubleFormat;
    }
}
