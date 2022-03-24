// Generated from /Users/ft/IdeaProjects/mexpa/grammar/Expression.g4 by ANTLR 4.9.2
package org.seniorlaguna.mexpa;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExpressionParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExpressionVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(ExpressionParser.ParseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(ExpressionParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#power}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPower(ExpressionParser.PowerContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#implicitMul}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplicitMul(ExpressionParser.ImplicitMulContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#prefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefix(ExpressionParser.PrefixContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#suffix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuffix(ExpressionParser.SuffixContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#mulDiv}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDiv(ExpressionParser.MulDivContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#addSub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(ExpressionParser.AddSubContext ctx);
}