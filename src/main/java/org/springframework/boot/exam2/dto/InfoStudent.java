package org.springframework.boot.exam2.dto;

import lombok.Data;

@Data
public class InfoStudent {
    private long studentId;
    private String student_code;
    private String full_name;
    private String address;
}
