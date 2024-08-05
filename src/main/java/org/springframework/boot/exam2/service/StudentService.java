package org.springframework.boot.exam2.service;

import org.springframework.boot.exam2.dto.InfoStudent;
import org.springframework.boot.exam2.dto.PageDto;
import org.springframework.boot.exam2.dto.Request.StudentDto;
import org.springframework.boot.exam2.dto.Request.StudentRequest;
import org.springframework.boot.exam2.model.Student;
import org.springframework.boot.exam2.projection.StudentProjection;

import java.util.List;

public interface StudentService {

    String add(Student student);

    PageDto search(StudentRequest studentRequest);
    InfoStudent findById(Long id);

    List<StudentProjection> newSearch(StudentRequest studentRequest);

    List<StudentProjection>getAll();
}
