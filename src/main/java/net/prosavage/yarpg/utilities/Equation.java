package net.prosavage.yarpg.utilities;

import com.udojava.evalex.Expression;
import java.math.BigDecimal;

public class Equation {

    public double parseDouble(String string){
        BigDecimal result;
        Expression expression = new Expression(string).setPrecision(10);
        result = expression.eval();
        return result.doubleValue();
    }

    public int parseInteger(String string){
        BigDecimal result;
        Expression expression = new Expression(string).setPrecision(10);
        result = expression.eval();
        return result.intValue();
    }

}
