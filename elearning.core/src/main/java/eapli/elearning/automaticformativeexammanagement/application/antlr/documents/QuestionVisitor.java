// Generated from C:/Users/ricar/IdeaProjects/sem4pi-22-23-58/elearning.core/src/main/java/eapli/elearning/automaticformativeexammanagement/application/antlr\Question.g4 by ANTLR 4.12.0
package eapli.elearning.automaticformativeexammanagement.application.antlr.documents;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link QuestionParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface QuestionVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link QuestionParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(QuestionParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionParser#matchingQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchingQuestion(QuestionParser.MatchingQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionParser#matchingquestionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchingquestionType(QuestionParser.MatchingquestionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionParser#matchingalinea}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchingalinea(QuestionParser.MatchingalineaContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionParser#matchingsolution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchingsolution(QuestionParser.MatchingsolutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionParser#matchingcotacao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchingcotacao(QuestionParser.MatchingcotacaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionParser#matchingquestionText}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchingquestionText(QuestionParser.MatchingquestionTextContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionParser#matchingtext}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchingtext(QuestionParser.MatchingtextContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionParser#matchingnumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchingnumber(QuestionParser.MatchingnumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionParser#multipleChoiceQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultipleChoiceQuestion(QuestionParser.MultipleChoiceQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionParser#multiplequestionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplequestionType(QuestionParser.MultiplequestionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionParser#multiplealinea}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplealinea(QuestionParser.MultiplealineaContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionParser#multiplesolution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplesolution(QuestionParser.MultiplesolutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionParser#multiplecotacao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplecotacao(QuestionParser.MultiplecotacaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionParser#multiplequestionText}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplequestionText(QuestionParser.MultiplequestionTextContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionParser#multipletext}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultipletext(QuestionParser.MultipletextContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionParser#multiplenumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplenumber(QuestionParser.MultiplenumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionParser#selectMissingWordsQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectMissingWordsQuestion(QuestionParser.SelectMissingWordsQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionParser#missingquestionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMissingquestionType(QuestionParser.MissingquestionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionParser#missingalinea}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMissingalinea(QuestionParser.MissingalineaContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionParser#missingsolution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMissingsolution(QuestionParser.MissingsolutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionParser#missingcotacao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMissingcotacao(QuestionParser.MissingcotacaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionParser#missingquestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMissingquestion(QuestionParser.MissingquestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionParser#feedback}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeedback(QuestionParser.FeedbackContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionParser#missingquestionText}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMissingquestionText(QuestionParser.MissingquestionTextContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionParser#missingnumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMissingnumber(QuestionParser.MissingnumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionParser#trueFalseQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueFalseQuestion(QuestionParser.TrueFalseQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionParser#tfquestionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTfquestionType(QuestionParser.TfquestionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionParser#tfsolution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTfsolution(QuestionParser.TfsolutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionParser#truefalseOptions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTruefalseOptions(QuestionParser.TruefalseOptionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionParser#tfcotacao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTfcotacao(QuestionParser.TfcotacaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionParser#tfquestionText}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTfquestionText(QuestionParser.TfquestionTextContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionParser#tfnumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTfnumber(QuestionParser.TfnumberContext ctx);
}