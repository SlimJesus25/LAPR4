// Generated from D:/ISEP/teste/elearning.core/src/main/java/eapli/elearning/exammanagement/domain/formativeexamantlr\FormativeExam.g4 by ANTLR 4.12.0
package eapli.elearning.exammanagement.domain.formativeexamantlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FormativeExamParser}.
 */
public interface FormativeExamListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FormativeExamParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(FormativeExamParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(FormativeExamParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamParser#title}.
	 * @param ctx the parse tree
	 */
	void enterTitle(FormativeExamParser.TitleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamParser#title}.
	 * @param ctx the parse tree
	 */
	void exitTitle(FormativeExamParser.TitleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamParser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeader(FormativeExamParser.HeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamParser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeader(FormativeExamParser.HeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamParser#header_feedback_grade}.
	 * @param ctx the parse tree
	 */
	void enterHeader_feedback_grade(FormativeExamParser.Header_feedback_gradeContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamParser#header_feedback_grade}.
	 * @param ctx the parse tree
	 */
	void exitHeader_feedback_grade(FormativeExamParser.Header_feedback_gradeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sectionText}
	 * labeled alternative in {@link FormativeExamParser#section}.
	 * @param ctx the parse tree
	 */
	void enterSectionText(FormativeExamParser.SectionTextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sectionText}
	 * labeled alternative in {@link FormativeExamParser#section}.
	 * @param ctx the parse tree
	 */
	void exitSectionText(FormativeExamParser.SectionTextContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sectionNoText}
	 * labeled alternative in {@link FormativeExamParser#section}.
	 * @param ctx the parse tree
	 */
	void enterSectionNoText(FormativeExamParser.SectionNoTextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sectionNoText}
	 * labeled alternative in {@link FormativeExamParser#section}.
	 * @param ctx the parse tree
	 */
	void exitSectionNoText(FormativeExamParser.SectionNoTextContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(FormativeExamParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(FormativeExamParser.QuestionContext ctx);
}