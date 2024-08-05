package org.springframework.boot.exam2.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private long studentId;
    private String student_code;
    private String full_name;
    private String address;
    private Double score1;
    private Double score2;
    private String subject_code;
    private String subject_name;
    private int credit;
}
