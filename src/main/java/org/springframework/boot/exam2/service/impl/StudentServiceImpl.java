package org.springframework.boot.exam2.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.exam2.config.ConfigMap;
import org.springframework.boot.exam2.dto.InfoStudent;
import org.springframework.boot.exam2.dto.PageDto;

import org.springframework.boot.exam2.dto.Request.StudentDto;
import org.springframework.boot.exam2.dto.Request.StudentRequest;
import org.springframework.boot.exam2.exception.NotFound;
import org.springframework.boot.exam2.mapper.StudentMapper;
import org.springframework.boot.exam2.model.Student;
import org.springframework.boot.exam2.projection.StudentProjection;
import org.springframework.boot.exam2.repository.StudentDao;
import org.springframework.boot.exam2.service.StudentService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentServiceImpl implements StudentService {
    public final StudentDao studentDao;
    private final StudentMapper studentMapper;


    @Override
    public String add(Student student) {
        studentDao.save(student);
        return "Ok";
    }

    @Override
    public PageDto search(StudentRequest studentRequest) {
        if (studentRequest.getPageSize() <= 0 || studentRequest.getPageSize() <= 0) {
            studentRequest.setPageSize(ConfigMap.pageSize);
            studentRequest.setPageNumber(ConfigMap.pageNumber);

        }
        Pageable page = PageRequest.of(studentRequest.getPageSize(), studentRequest.getPageNumber());
        List<Student> studentList = studentDao.findByUserName( studentRequest.getStudentName(),page);
        StudentDto studentDto = new StudentDto();

        PageDto pageDto = new PageDto();
        pageDto.setContent(studentList);
        pageDto.setPageNumber(studentRequest.getPageNumber());
        pageDto.setPageSize(studentRequest.getPageSize());
        pageDto.setPageNumber(page.getPageNumber());
        return pageDto;
    }



    @Override
    public InfoStudent findById(Long id) {
        Student student = studentDao.findById(id).orElseThrow(()-> new NotFound("not found"+id ));

        return studentMapper.toEntity(student);
    }

    @Override
    public List<StudentProjection> newSearch(StudentRequest studentRequest) {
        if (studentRequest.getPageSize() <= 0 || studentRequest.getPageNumber() <= 0) {
            studentRequest.setPageSize(ConfigMap.pageSize);
            studentRequest.setPageNumber(ConfigMap.pageNumber);

        }
        return studentDao.findByUserName1(studentRequest.getStudentName(),PageRequest.of(studentRequest.getPageNumber(), studentRequest.getPageSize()));
    }
}
