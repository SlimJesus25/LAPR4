// Generated from D:/ISEP/teste/elearning.core/src/main/java/eapli/elearning/exammanagement/domain/formativeexamupdateantlr\UpdateFormativeExam.g4 by ANTLR 4.12.0
package eapli.elearning.exammanagement.domain.formativeexamupdateantlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link UpdateFormativeExamParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface UpdateFormativeExamVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link UpdateFormativeExamParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(UpdateFormativeExamParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link UpdateFormativeExamParser#title}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTitle(UpdateFormativeExamParser.TitleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code headerfgNoText}
	 * labeled alternative in {@link UpdateFormativeExamParser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeaderfgNoText(UpdateFormativeExamParser.HeaderfgNoTextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code headerfg}
	 * labeled alternative in {@link UpdateFormativeExamParser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeaderfg(UpdateFormativeExamParser.HeaderfgContext ctx);
	/**
	 * Visit a parse tree produced by {@link UpdateFormativeExamParser#header_feedback_grade}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeader_feedback_grade(UpdateFormativeExamParser.Header_feedback_gradeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sectionText}
	 * labeled alternative in {@link UpdateFormativeExamParser#section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSectionText(UpdateFormativeExamParser.SectionTextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sectionNoText}
	 * labeled alternative in {@link UpdateFormativeExamParser#section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSectionNoText(UpdateFormativeExamParser.SectionNoTextContext ctx);
	/**
	 * Visit a parse tree produced by {@link UpdateFormativeExamParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(UpdateFormativeExamParser.QuestionContext ctx);
}