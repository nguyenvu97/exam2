package org.springframework.boot.exam2.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.exam2.model.Subject;
import org.springframework.boot.exam2.repository.SubjectDao;
import org.springframework.boot.exam2.service.SubjectService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class SubjectServiceImpl implements SubjectService {
    public final SubjectDao subjectDao;

    @Override
    public String add(Subject subject) {
        subjectDao.save(subject);
        return "Ok";
    }
}
