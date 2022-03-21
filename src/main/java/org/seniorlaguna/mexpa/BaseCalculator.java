package org.seniorlaguna.mexpa;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.math.BigDecimal;

public abstract class BaseCalculator<T> extends ExpressionBaseVisitor<T> {

    public T evaluate(String expression) {
        CodePointCharStream charStream = CharStreams.fromString(expression);
        ExpressionLexer lexer = new ExpressionLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        ExpressionParser parser = new ExpressionParser(tokenStream);
        ParseTree tree = parser.entrypoint();
        return visit(tree);
    }

    @Override
    public abstract T visitPow(ExpressionParser.PowContext ctx);

    @Override
    public abstract T visitUnaryMinus(ExpressionParser.UnaryMinusContext ctx);

    @Override
    public abstract T visitImplicitMul(ExpressionParser.ImplicitMulContext ctx);

    @Override
    public abstract T visitBrackets(ExpressionParser.BracketsContext ctx);

    @Override
    public abstract T visitAddOrSub(ExpressionParser.AddOrSubContext ctx);

    @Override
    public abstract T visitMulOrDiv(ExpressionParser.MulOrDivContext ctx);

    @Override
    public abstract T visitNumber(ExpressionParser.NumberContext ctx);
}
