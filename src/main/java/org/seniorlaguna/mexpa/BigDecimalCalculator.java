package org.seniorlaguna.mexpa;

import ch.obermuhlner.math.big.BigDecimalMath;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public final class BigDecimalCalculator extends BaseCalculator<BigDecimal> {

    private MathContext mathContext;
    private int decimalPlaces;
    private boolean useRadians;


    public BigDecimalCalculator(int decimalPlaces, boolean roundingUp, boolean useRadians, int precision) throws InvalidStartUpConfigurationException {
        if (decimalPlaces < 0 || precision < 0) throw new InvalidStartUpConfigurationException();

        mathContext = new MathContext(precision, roundingUp ? RoundingMode.UP : RoundingMode.DOWN);
        this.decimalPlaces = decimalPlaces;
        this.useRadians = useRadians;
    }

    private BigDecimal degreesToRadians(BigDecimal degrees) {
        BigDecimal factor = BigDecimalMath.pi(mathContext).divide(new BigDecimal(180), mathContext);
        return degrees.multiply(factor);
    }

    @Override
    public BigDecimal evaluate(String expression) {
        return super.evaluate(expression).setScale(decimalPlaces, mathContext.getRoundingMode()).stripTrailingZeros();
    }

    @Override
    public BigDecimal toNumber(String number) {
        return BigDecimalMath.toBigDecimal(number);
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
        return left.divide(right, MathContext.DECIMAL128);
    }

    @Override
    public BigDecimal pow(BigDecimal left, BigDecimal right) {
        return BigDecimalMath.pow(left, right, MathContext.DECIMAL128);
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
    public boolean isConstant(String constantName) {
        return constantName.equals("e") || constantName.equals("π");
    }

    @Override
    public BigDecimal callFunction(String functionName, BigDecimal x) throws UnknownFunctionException {
        switch (functionName) {
            case "sin":
                if (!useRadians) x = degreesToRadians(x);
                return BigDecimalMath.sin(x, MathContext.DECIMAL32);
            case "cos":
                if (!useRadians) x = degreesToRadians(x);
                return BigDecimalMath.cos(x, mathContext);
            case "tan":
                if (!useRadians) x = degreesToRadians(x);
                return BigDecimalMath.tan(x, MathContext.DECIMAL32);
            case "√":
                return BigDecimalMath.sqrt(x, mathContext);
            default:
                throw new UnknownFunctionException(functionName);
        }
    }

    @Override
    public BigDecimal resolveConstant(String constantName) throws UnknownConstantException {
        switch (constantName) {
            case "e":
                return BigDecimalMath.e(mathContext);
            case "π":
                return BigDecimalMath.pi(mathContext);
            default:
                throw new UnknownConstantException(constantName);
        }
    }

    public void setDecimalPlaces(int decimalPlaces) {
        if (decimalPlaces < 0) return;
        this.decimalPlaces = decimalPlaces;
    }

    public int getDecimalPlaces() {
        return decimalPlaces;
    }

    public void setRoundingUp(boolean roundUp) {
        mathContext = new MathContext(mathContext.getPrecision(), roundUp ? RoundingMode.UP : RoundingMode.DOWN);
    }

    public boolean getRoundingUp() {
        return mathContext.getRoundingMode() == RoundingMode.UP;
    }

    public void setUseRadians(boolean useRadians) {
        this.useRadians = useRadians;
    }

    public boolean getUseRadians() {
        return useRadians;
    }

    public void setPrecision(int precision) {
        if (precision < 0) return;
        mathContext = new MathContext(precision, mathContext.getRoundingMode());
    }

    public int getPrecision() {
        return mathContext.getPrecision();
    }

    static public class InvalidStartUpConfigurationException extends RuntimeException { }
}

