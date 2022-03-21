import org.seniorlaguna.mexpa.BaseCalculator;
import org.seniorlaguna.mexpa.ExpressionParser;

import java.math.BigDecimal;

public final class BigDecimalCalculator extends BaseCalculator<BigDecimal> {

    private String removeSpaces(String text) {
        return text.replaceAll(" ", "");
    }

    @Override
    public BigDecimal visitPow(ExpressionParser.PowContext ctx) {
        BigDecimal left = visit(ctx.left);
        BigDecimal right = visit(ctx.right);
        return left.pow(right.intValue());
    }

    @Override
    public BigDecimal visitUnaryMinus(ExpressionParser.UnaryMinusContext ctx) {
        BigDecimal number = visit(ctx.expression());
        return number.multiply(new BigDecimal(-1));
    }

    @Override
    public BigDecimal visitImplicitMul(ExpressionParser.ImplicitMulContext ctx) {
        BigDecimal left = visit(ctx.left);
        BigDecimal right = visit(ctx.right);
        return left.multiply(right);
    }

    @Override
    public BigDecimal visitBrackets(ExpressionParser.BracketsContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public BigDecimal visitMulOrDiv(ExpressionParser.MulOrDivContext ctx) {
        BigDecimal left = visit(ctx.left);
        BigDecimal right = visit(ctx.right);
        String operator = ctx.op.getText();

        if (operator.equals("*")) return left.multiply(right);
        return left.divide(right);
    }

    @Override
    public BigDecimal visitAddOrSub(ExpressionParser.AddOrSubContext ctx) {
        BigDecimal left = visit(ctx.left);
        BigDecimal right = visit(ctx.right);
        String operator = ctx.op.getText();

        if (operator.equals("+")) return left.add(right);
        return left.subtract(right);

    }

    @Override
    public BigDecimal visitNumber(ExpressionParser.NumberContext ctx) {
        String number = removeSpaces(ctx.NUMBER().getText());
        return new BigDecimal(number);
    }
}

