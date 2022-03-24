import ch.obermuhlner.math.big.BigDecimalMath;
import org.seniorlaguna.mexpa.BaseCalculator;

import java.math.BigDecimal;
import java.math.MathContext;

public final class BigDecimalCalculator extends BaseCalculator<BigDecimal> {

    @Override
    public BigDecimal toNumber(String number) {
        return new BigDecimal(number);
    }

    @Override
    public BigDecimal add(BigDecimal left, BigDecimal right) {
        return left.add(right);
    }

    @Override
    public BigDecimal subtract(BigDecimal left, BigDecimal right) {
        return left.subtract(right);
    }

    @Override
    public BigDecimal multiply(BigDecimal left, BigDecimal right) {
        return left.multiply(right);
    }

    @Override
    public BigDecimal divide(BigDecimal left, BigDecimal right) {
        return left.divide(right);
    }

    @Override
    public BigDecimal pow(BigDecimal left, BigDecimal right) {
        return left.pow(right.intValue());
    }

    @Override
    public BigDecimal negate(BigDecimal number) {
        return number.multiply(new BigDecimal(-1));
    }

    @Override
    public BigDecimal toPercentage(BigDecimal number) {
        return number.divide(new BigDecimal(100));
    }

    @Override
    public BigDecimal toPercentage(BigDecimal number, BigDecimal fraction) {
        return number.multiply(fraction.divide(new BigDecimal(100)));
    }

    @Override
    public BigDecimal factorial(BigDecimal number) {
        return BigDecimalMath.factorial(number, MathContext.DECIMAL32);
    }

    @Override
    public BigDecimal callFunction(String functionName, BigDecimal x) {
        switch (functionName) {
            case "√":
                return BigDecimalMath.sqrt(x, MathContext.DECIMAL32);
            default:
                return x;
        }
    }

    @Override
    public BigDecimal resolveConstant(String constantName) {
        switch (constantName) {
            case "e":
                return new BigDecimal(2.7);
            default:
                return BigDecimal.ONE;
        }
    }
}

