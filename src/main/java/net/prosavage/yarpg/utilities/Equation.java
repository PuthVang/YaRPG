package net.prosavage.yarpg.utilities;

import com.ezylang.evalex.EvaluationException;
import com.ezylang.evalex.Expression;
import com.ezylang.evalex.parser.ParseException;

import java.math.BigDecimal;

public class Equation {

    BigDecimal result;

    public Equation(String string){
        Expression expression = new Expression(string);
        try {
            result = expression.evaluate().getNumberValue();
        } catch (EvaluationException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public double getDouble(){
        return result.doubleValue();
    }

    public int getInteger(){
        return result.intValue();
    }

}
