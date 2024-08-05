package org.springframework.boot.exam2.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.exam2.exception.NotFound;
import org.springframework.boot.exam2.model.Student;
import org.springframework.boot.exam2.model.StudentScore;
import org.springframework.boot.exam2.model.Subject;
import org.springframework.boot.exam2.repository.StudentDao;
import org.springframework.boot.exam2.repository.StudentScoreDao;
import org.springframework.boot.exam2.repository.SubjectDao;
import org.springframework.boot.exam2.service.StudentScoreService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional

public class StudentScoreServiceImpl implements StudentScoreService {

    public final StudentScoreDao studentScoreDao;

    public final StudentDao studentDao;
    public final SubjectDao subjectDao;


    @Override
    public String add(StudentScore studentScore,long studentId, long subjectId) {
        Student student = studentDao.findById(studentId).orElseThrow(()-> new NotFound("student not found"));
        Subject subject = subjectDao.findById(subjectId).orElseThrow(()-> new NotFound("subject not found"));
        studentScoreDao.save(StudentScore
                        .builder()
                        .score2(studentScore.getScore2())
                        .score1(studentScore.getScore1())
                        .student(student)
                        .subject(subject)
                        .build());
        return "Ok";
    }
}
