package eapli.elearning.exammanagement.domain;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.coursemanagement.repositories.CourseRepository;
import eapli.elearning.exammanagement.repository.ExamQuestionRepository;
import eapli.elearning.exammanagement.repository.ExamRepository;
import eapli.elearning.exammanagement.repository.ExamSectionRepository;
import eapli.elearning.examquestionmanagement.domain.ExamQuestion;
import eapli.elearning.examquestionmanagement.domain.ExamQuestionType;
import eapli.elearning.examsectionmanagement.domain.ExamSection;
import eapli.elearning.examsectionmanagement.domain.SectionFactory;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.framework.domain.services.DomainService;
import java.util.*;


/**
 * @author : Ricardo Venâncio - 1210828
 **/
@DomainService
public class CreateAutomaticFormativeExamService {
    CourseRepository courseRepo = PersistenceContext.repositories().courses();
    ExamSectionRepository sectionRepo = PersistenceContext.repositories().examSections();
    ExamQuestionRepository examQuestionRepo = PersistenceContext.repositories().examQuestions();
    ExamRepository examRepo = PersistenceContext.repositories().exams();
    public Exam createAutomaticFormativeExam(String title, String header
            , HashMap<String, List<ExamQuestionType>> sectionQuestionTypes, CourseDTO courseDTO) {

        Course course = courseRepo.findCourseByCode(courseDTO.getCourseCode());

        Set<ExamSection> sections = new HashSet<>();

        digitalizeAndPersistQuestionsAndSections(course, sectionQuestionTypes, sections);

        Exam theExam = ExamFactory.createFormativeExam(title, header, sections, course);
        return examRepo.save(theExam);
    }

    private void digitalizeAndPersistQuestionsAndSections(Course course, HashMap<String
            , List<ExamQuestionType>> sections2, Set<ExamSection> sectionsPers){
        Set<ExamQuestionType> wantedQuestions = new HashSet<>();

        for(Map.Entry<String, List<ExamQuestionType>> entry : sections2.entrySet()){
            wantedQuestions.addAll(entry.getValue());
        }

        List<ExamQuestion> questions = examQuestionRepo.listQuestionsByTypeAndCourse(course, wantedQuestions);

        Set<ExamSection> sections = new HashSet<>();
        for(Map.Entry<String, List<ExamQuestionType>> entry : sections2.entrySet()){
            Set<ExamQuestion> questionTypes = new HashSet<>();
            for(ExamQuestionType questionType : entry.getValue()) {
                try {
                    ExamQuestion question = null;
                    for(ExamQuestion existingQuestion : questions){
                        if(existingQuestion.questionType().equals(questionType)){
                            question = existingQuestion;
                            questionTypes.add(question);
                            questions.remove(question);
                            break;
                        }
                    }
                    if(question == null){
                        throw new NullPointerException();
                    }
                }catch (NullPointerException e){
                    throw new IllegalArgumentException("There are no sufficient question of type " + questionType
                            + " in the repository in order to create this formative exam!");
                }
            }
            ExamSection section = SectionFactory.createSection(entry.getKey(), questionTypes);
            sections.add(section);
        }

        for(ExamSection section : sections){
            sectionsPers.add(sectionRepo.save(section));
        }
    }

    public Exam updateAutomaticFormativeExam(Exam exam, HashMap<String, List<ExamQuestionType>> sections){
        Set<ExamSection> sectionsPers = new HashSet<>();
        digitalizeAndPersistQuestionsAndSections(exam.course(), sections, sectionsPers);
        sectionsPers.forEach(exam::addSection);
        return examRepo.save(exam);
    }
}
