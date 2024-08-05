package org.springframework.boot.exam2.service;

import org.springframework.boot.exam2.model.StudentScore;

public interface StudentScoreService {

    String add(StudentScore studentScore,long studentId, long subjectId);
}
