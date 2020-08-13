package net.prosavage.yarpg.utilities;

import com.udojava.evalex.Expression;
import java.math.BigDecimal;

public class Equation {

    BigDecimal result;

    public Equation(String string){
        Expression expression = new Expression(string).setPrecision(10);
        result = expression.eval();
    }

    public double getDouble(){
        return result.doubleValue();
    }

    public int getInteger(){
        return result.intValue();
    }

}
