// Generated from C:/Users/Vicen/IdeaProjects/sem4pi-22-23-59/elearning.core/src/main/java/eapli/elearning/examquestionmanagement/application/antlr\Answers.g4 by ANTLR 4.12.0
package eapli.elearning.examquestionmanagement.application.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AnswersParser}.
 */
public interface AnswersListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AnswersParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(AnswersParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswersParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(AnswersParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MissingWords}
	 * labeled alternative in {@link AnswersParser#answers}.
	 * @param ctx the parse tree
	 */
	void enterMissingWords(AnswersParser.MissingWordsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MissingWords}
	 * labeled alternative in {@link AnswersParser#answers}.
	 * @param ctx the parse tree
	 */
	void exitMissingWords(AnswersParser.MissingWordsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Matchings}
	 * labeled alternative in {@link AnswersParser#answers}.
	 * @param ctx the parse tree
	 */
	void enterMatchings(AnswersParser.MatchingsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Matchings}
	 * labeled alternative in {@link AnswersParser#answers}.
	 * @param ctx the parse tree
	 */
	void exitMatchings(AnswersParser.MatchingsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultipleChoice}
	 * labeled alternative in {@link AnswersParser#answers}.
	 * @param ctx the parse tree
	 */
	void enterMultipleChoice(AnswersParser.MultipleChoiceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultipleChoice}
	 * labeled alternative in {@link AnswersParser#answers}.
	 * @param ctx the parse tree
	 */
	void exitMultipleChoice(AnswersParser.MultipleChoiceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TrueOrFalse}
	 * labeled alternative in {@link AnswersParser#answers}.
	 * @param ctx the parse tree
	 */
	void enterTrueOrFalse(AnswersParser.TrueOrFalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TrueOrFalse}
	 * labeled alternative in {@link AnswersParser#answers}.
	 * @param ctx the parse tree
	 */
	void exitTrueOrFalse(AnswersParser.TrueOrFalseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Numericals}
	 * labeled alternative in {@link AnswersParser#answers}.
	 * @param ctx the parse tree
	 */
	void enterNumericals(AnswersParser.NumericalsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Numericals}
	 * labeled alternative in {@link AnswersParser#answers}.
	 * @param ctx the parse tree
	 */
	void exitNumericals(AnswersParser.NumericalsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ShortAnswer}
	 * labeled alternative in {@link AnswersParser#answers}.
	 * @param ctx the parse tree
	 */
	void enterShortAnswer(AnswersParser.ShortAnswerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ShortAnswer}
	 * labeled alternative in {@link AnswersParser#answers}.
	 * @param ctx the parse tree
	 */
	void exitShortAnswer(AnswersParser.ShortAnswerContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswersParser#truefalse}.
	 * @param ctx the parse tree
	 */
	void enterTruefalse(AnswersParser.TruefalseContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswersParser#truefalse}.
	 * @param ctx the parse tree
	 */
	void exitTruefalse(AnswersParser.TruefalseContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswersParser#matching}.
	 * @param ctx the parse tree
	 */
	void enterMatching(AnswersParser.MatchingContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswersParser#matching}.
	 * @param ctx the parse tree
	 */
	void exitMatching(AnswersParser.MatchingContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswersParser#multiple}.
	 * @param ctx the parse tree
	 */
	void enterMultiple(AnswersParser.MultipleContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswersParser#multiple}.
	 * @param ctx the parse tree
	 */
	void exitMultiple(AnswersParser.MultipleContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswersParser#numerical}.
	 * @param ctx the parse tree
	 */
	void enterNumerical(AnswersParser.NumericalContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswersParser#numerical}.
	 * @param ctx the parse tree
	 */
	void exitNumerical(AnswersParser.NumericalContext ctx);
}