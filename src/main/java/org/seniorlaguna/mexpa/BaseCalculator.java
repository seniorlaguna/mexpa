package org.seniorlaguna.mexpa;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public abstract class BaseCalculator<T> extends ExpressionBaseVisitor<T> {

    private String removeSpaces(String number) {
        return number.replaceAll(" ", "");
    }

    final public T evaluate(String expression) {
        CodePointCharStream charStream = CharStreams.fromString(expression);
        ExpressionLexer lexer = new ExpressionLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        ExpressionParser parser = new ExpressionParser(tokenStream);
        ParseTree tree = parser.parse();
        return visit(tree);
    }


    @Override
    public T visitAddSub(ExpressionParser.AddSubContext ctx) {
        if (ctx.left == null) return visit(ctx.mulDiv());

        T left = visit(ctx.left);
        T right = visit(ctx.right);
        boolean isPercentage = (ctx.suf != null);

        if (isPercentage) right = toPercentage(left, right);

        if (ctx.op.getText().equals("+")) return add(left, right);
        return subtract(left, right);
    }

    @Override
    public T visitMulDiv(ExpressionParser.MulDivContext ctx) {
        if (ctx.left == null) return visit(ctx.suffix());

        T left = visit(ctx.left);
        T right = visit(ctx.right);

        if (ctx.op.getText().equals("*")) return multiply(left, right);
        return divide(left, right);
    }

    @Override
    public T visitSuffix(ExpressionParser.SuffixContext ctx) {
        if (ctx.number == null) return visit(ctx.prefix());

        T number = visit(ctx.number);

        if (ctx.op.getText().equals("%")) return toPercentage(number);
        return factorial(number);
    }

    @Override
    public T visitPrefix(ExpressionParser.PrefixContext ctx) {
        if (ctx.number == null) return visit(ctx.implicitMul());

        T number = visit(ctx.number);

        return negate(number);
    }

    @Override
    public T visitImplicitMul(ExpressionParser.ImplicitMulContext ctx) {
        if (ctx.left == null) return visit(ctx.power());

        T left = visit(ctx.left);
        T right = visit(ctx.right);

        return multiply(left, right);
    }

    @Override
    public T visitPower(ExpressionParser.PowerContext ctx) {
        if (ctx.left == null) return visit(ctx.function());

        T left = visit(ctx.left);
        T right = visit(ctx.right);

        return pow(left, right);
    }

    @Override
    public T visitFunction(ExpressionParser.FunctionContext ctx) {
        if (ctx.name == null) return visit(ctx.constant());

        String function = ctx.name.getText();
        T number = visit(ctx.x);

        return callFunction(function, number);
    }

    @Override
    public T visitConstant(ExpressionParser.ConstantContext ctx) {
        if (ctx.name == null) return visit(ctx.term());

        return resolveConstant(ctx.name.getText());
    }

    @Override
    public T visitTerm(ExpressionParser.TermContext ctx) {
        if (ctx.number == null) return toNumber(removeSpaces(ctx.NUMBER().getText()));

        return visit(ctx.number);
    }

    public abstract T toNumber(String number);

    public abstract T add(T left, T right);

    public abstract T subtract(T left, T right);

    public abstract T multiply(T left, T right);

    public abstract T divide(T left, T right);

    public abstract T pow(T left, T right);

    public abstract T negate(T number);

    public abstract T toPercentage(T number);

    public abstract T toPercentage(T number, T fraction);

    public abstract T factorial(T number);

    public abstract T callFunction(String functionName, T x);

    public abstract T resolveConstant(String constantName);
}
