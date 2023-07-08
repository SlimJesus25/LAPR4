package eapli.elearning.exammanagement.application;

import eapli.elearning.exammanagement.dto.ExamDTO;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

public interface IExamService {
    Iterable<ExamDTO> listUserExams(SystemUser user);
}
