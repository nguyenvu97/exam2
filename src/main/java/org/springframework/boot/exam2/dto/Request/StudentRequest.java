package org.springframework.boot.exam2.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.boot.exam2.dto.PageDto;
import org.springframework.data.domain.PageRequest;



public class StudentRequest extends PageDto {
    public String studentName;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}

