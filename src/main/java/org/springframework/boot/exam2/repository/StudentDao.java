package org.springframework.boot.exam2.repository;

import org.springframework.boot.exam2.model.Student;
import org.springframework.boot.exam2.projection.StudentProjection;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao  extends JpaRepository<Student, Long> {

    List<Student> findByUserName(String studentName, Pageable pageable);

    @Query("select s.id as studentId, "+
            "s.studentCode as studentCode, "+
            "s.studentName as studentName, "+
            "s.address as address, "+
            "ss.score1 as score1, "+
            "ss.score2 as score2," +
            "sub.subjectCode as subjectCode ," +
            "sub.subjectName as subjectName , " +
            "sub.credit as credit "+
            " from Student as s  " +
            "left join  StudentScore  as ss on ss.student.id = s.id  " +
            "left join  Subject as sub on ss.subject.id  = sub.id  " +
            "where s.studentName like %=:studentName%")
    List<StudentProjection> findByUserName1(@Param(value = "studentName") String studentName, Pageable pageable);
}
