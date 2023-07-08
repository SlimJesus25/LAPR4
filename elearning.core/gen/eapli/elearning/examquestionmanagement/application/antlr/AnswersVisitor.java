// Generated from C:/Users/Vicen/IdeaProjects/sem4pi-22-23-59/elearning.core/src/main/java/eapli/elearning/examquestionmanagement/application/antlr\Answers.g4 by ANTLR 4.12.0
package eapli.elearning.examquestionmanagement.application.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AnswersParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AnswersVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AnswersParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(AnswersParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MissingWords}
	 * labeled alternative in {@link AnswersParser#answers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMissingWords(AnswersParser.MissingWordsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Matchings}
	 * labeled alternative in {@link AnswersParser#answers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchings(AnswersParser.MatchingsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultipleChoice}
	 * labeled alternative in {@link AnswersParser#answers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultipleChoice(AnswersParser.MultipleChoiceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TrueOrFalse}
	 * labeled alternative in {@link AnswersParser#answers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueOrFalse(AnswersParser.TrueOrFalseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Numericals}
	 * labeled alternative in {@link AnswersParser#answers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericals(AnswersParser.NumericalsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ShortAnswer}
	 * labeled alternative in {@link AnswersParser#answers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShortAnswer(AnswersParser.ShortAnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswersParser#truefalse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTruefalse(AnswersParser.TruefalseContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswersParser#matching}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatching(AnswersParser.MatchingContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswersParser#multiple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiple(AnswersParser.MultipleContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswersParser#numerical}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumerical(AnswersParser.NumericalContext ctx);
}