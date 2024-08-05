package org.springframework.boot.exam2.mapper;

import org.mapstruct.Mapper;
import org.springframework.boot.exam2.dto.InfoStudent;
import org.springframework.boot.exam2.model.Student;

import java.util.List;

@Mapper(config = MapperConfig.class)
public interface StudentMapper extends MapperAll<Student, InfoStudent>{
    @Override
    Student toDto(InfoStudent infoStudent);

    @Override
    InfoStudent toEntity(Student student);

    @Override
    List<Student> toListEntity(List<InfoStudent> d);

    @Override
    List<InfoStudent> toListDto(List<Student> e);
}
