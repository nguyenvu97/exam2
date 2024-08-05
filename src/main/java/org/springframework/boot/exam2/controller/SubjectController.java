package org.springframework.boot.exam2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.exam2.dto.Request.ProductRequest;
import org.springframework.boot.exam2.exception.NotFound;
import org.springframework.boot.exam2.model.Student;
import org.springframework.boot.exam2.model.Subject;
import org.springframework.boot.exam2.service.SubjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/subject")
public class SubjectController {
    private final SubjectService subjectService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Subject subject) {
        return ResponseEntity.ok().body(subjectService.add(subject));
    }

}
