// Generated from D:/ISEP/teste/elearning.core/src/main/java/eapli/elearning/exammanagement/domain/formativeexamupdateantlr\UpdateFormativeExam.g4 by ANTLR 4.12.0
package eapli.elearning.exammanagement.domain.formativeexamupdateantlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link UpdateFormativeExamParser}.
 */
public interface UpdateFormativeExamListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link UpdateFormativeExamParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(UpdateFormativeExamParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link UpdateFormativeExamParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(UpdateFormativeExamParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link UpdateFormativeExamParser#title}.
	 * @param ctx the parse tree
	 */
	void enterTitle(UpdateFormativeExamParser.TitleContext ctx);
	/**
	 * Exit a parse tree produced by {@link UpdateFormativeExamParser#title}.
	 * @param ctx the parse tree
	 */
	void exitTitle(UpdateFormativeExamParser.TitleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code headerfgNoText}
	 * labeled alternative in {@link UpdateFormativeExamParser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeaderfgNoText(UpdateFormativeExamParser.HeaderfgNoTextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code headerfgNoText}
	 * labeled alternative in {@link UpdateFormativeExamParser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeaderfgNoText(UpdateFormativeExamParser.HeaderfgNoTextContext ctx);
	/**
	 * Enter a parse tree produced by the {@code headerfg}
	 * labeled alternative in {@link UpdateFormativeExamParser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeaderfg(UpdateFormativeExamParser.HeaderfgContext ctx);
	/**
	 * Exit a parse tree produced by the {@code headerfg}
	 * labeled alternative in {@link UpdateFormativeExamParser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeaderfg(UpdateFormativeExamParser.HeaderfgContext ctx);
	/**
	 * Enter a parse tree produced by {@link UpdateFormativeExamParser#header_feedback_grade}.
	 * @param ctx the parse tree
	 */
	void enterHeader_feedback_grade(UpdateFormativeExamParser.Header_feedback_gradeContext ctx);
	/**
	 * Exit a parse tree produced by {@link UpdateFormativeExamParser#header_feedback_grade}.
	 * @param ctx the parse tree
	 */
	void exitHeader_feedback_grade(UpdateFormativeExamParser.Header_feedback_gradeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sectionText}
	 * labeled alternative in {@link UpdateFormativeExamParser#section}.
	 * @param ctx the parse tree
	 */
	void enterSectionText(UpdateFormativeExamParser.SectionTextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sectionText}
	 * labeled alternative in {@link UpdateFormativeExamParser#section}.
	 * @param ctx the parse tree
	 */
	void exitSectionText(UpdateFormativeExamParser.SectionTextContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sectionNoText}
	 * labeled alternative in {@link UpdateFormativeExamParser#section}.
	 * @param ctx the parse tree
	 */
	void enterSectionNoText(UpdateFormativeExamParser.SectionNoTextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sectionNoText}
	 * labeled alternative in {@link UpdateFormativeExamParser#section}.
	 * @param ctx the parse tree
	 */
	void exitSectionNoText(UpdateFormativeExamParser.SectionNoTextContext ctx);
	/**
	 * Enter a parse tree produced by {@link UpdateFormativeExamParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(UpdateFormativeExamParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UpdateFormativeExamParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(UpdateFormativeExamParser.QuestionContext ctx);
}