package eapli.elearning.exammanagement.application;

import eapli.elearning.exammanagement.dto.ExamDTO;
import eapli.framework.application.ApplicationService;

@ApplicationService
public class FormerExamValidationService {
        public boolean validate(ExamDTO exam) {
            return exam.getFinalDateTime().isAfter(java.time.LocalDateTime.now());
        }
}
