// Generated from C:/Users/ricar/IdeaProjects/sem4pi-22-23-58/elearning.core/src/main/java/eapli/elearning/exammanagement/application/antlr\US2001.g4 by ANTLR 4.12.0
package eapli.elearning.exammanagement.application.antlr.documents;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link US2001Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface US2001Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link US2001Parser#exam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExam(US2001Parser.ExamContext ctx);
	/**
	 * Visit a parse tree produced by {@link US2001Parser#inicaldate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInicaldate(US2001Parser.InicaldateContext ctx);
	/**
	 * Visit a parse tree produced by {@link US2001Parser#finaldate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinaldate(US2001Parser.FinaldateContext ctx);
	/**
	 * Visit a parse tree produced by {@link US2001Parser#title}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTitle(US2001Parser.TitleContext ctx);
	/**
	 * Visit a parse tree produced by {@link US2001Parser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeader(US2001Parser.HeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link US2001Parser#courseCode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCourseCode(US2001Parser.CourseCodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link US2001Parser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(US2001Parser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link US2001Parser#section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSection(US2001Parser.SectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link US2001Parser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(US2001Parser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link US2001Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(US2001Parser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link US2001Parser#solution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSolution(US2001Parser.SolutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link US2001Parser#matchingsolution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchingsolution(US2001Parser.MatchingsolutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link US2001Parser#multiplesolution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplesolution(US2001Parser.MultiplesolutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link US2001Parser#shortsolution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShortsolution(US2001Parser.ShortsolutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link US2001Parser#textsolution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextsolution(US2001Parser.TextsolutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link US2001Parser#feedback}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeedback(US2001Parser.FeedbackContext ctx);
	/**
	 * Visit a parse tree produced by {@link US2001Parser#options}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptions(US2001Parser.OptionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link US2001Parser#questionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionType(US2001Parser.QuestionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link US2001Parser#quotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuotation(US2001Parser.QuotationContext ctx);
}