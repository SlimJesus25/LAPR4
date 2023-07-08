// Generated from D:/ISEP/teste/elearning.core/src/main/java/eapli/elearning/exammanagement/domain/formativeexamantlr\FormativeExam.g4 by ANTLR 4.12.0
package eapli.elearning.exammanagement.domain.formativeexamantlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FormativeExamParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FormativeExamVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FormativeExamParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(FormativeExamParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamParser#title}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTitle(FormativeExamParser.TitleContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamParser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeader(FormativeExamParser.HeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamParser#header_feedback_grade}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeader_feedback_grade(FormativeExamParser.Header_feedback_gradeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sectionText}
	 * labeled alternative in {@link FormativeExamParser#section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSectionText(FormativeExamParser.SectionTextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sectionNoText}
	 * labeled alternative in {@link FormativeExamParser#section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSectionNoText(FormativeExamParser.SectionNoTextContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(FormativeExamParser.QuestionContext ctx);
}