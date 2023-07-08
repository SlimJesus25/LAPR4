package eapli.elearning.extralectureparticipantmanagement.domain;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.extralecturemanagement.domain.*;
import eapli.elearning.extralecturemanagement.dto.ExtraLectureDTO;
import eapli.elearning.extralectureparticipantmanagement.dto.ExtraLectureParticipantDTO;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class ExtraLectureParticipant  implements AggregateRoot<Integer>, DTOable<ExtraLectureParticipantDTO> {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @ManyToOne
        private ExtraLecture extraLecture;

        @ManyToOne
        private Student student;

        public ExtraLectureParticipant(ExtraLecture extraLecture, Student student) {
            Preconditions.noneNull(extraLecture, student);
            this.extraLecture=extraLecture;
            this.student=student;
        }
        public ExtraLectureParticipant(){

        }
        public ExtraLecture extraLecture() {
            return extraLecture;
        }
        public Student student() {
            return student;
        }
        @Override
        public boolean sameAs(Object other) {
            return false;
        }

        @Override
        public Integer identity() {
            return id;
        }

        @Override
        public ExtraLectureParticipantDTO toDTO() {
            return new ExtraLectureParticipantDTO(extraLecture.toDTO(), student.toDTO());
        }
    }
