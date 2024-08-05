package org.springframework.boot.exam2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.exam2.dto.Request.StudentRequest;
import org.springframework.boot.exam2.exception.NotFound;
import org.springframework.boot.exam2.model.Product;
import org.springframework.boot.exam2.model.Student;
import org.springframework.boot.exam2.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/student")
public class StudentController {
    private final StudentService studentService;
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Student student) {
            return ResponseEntity.ok().body(studentService.add(student));
    }
    @GetMapping("/find")
    public ResponseEntity<?> find (@RequestParam long studentId) {
        try {
            return ResponseEntity.ok().body(studentService.findById(studentId));

        }catch (NotFound e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/search")
    public ResponseEntity<?> search (@RequestBody StudentRequest studentRequest ) {
        return ResponseEntity.ok().body(studentService.newSearch(studentRequest));
    }

}
