package com.mywarehouse.restcontroller;

import com.mywarehouse.entity.Student;
import com.mywarehouse.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/v1")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudent(@PathVariable Long studentId) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findById(studentId));
    }

    @GetMapping("/bySurname")
    public ResponseEntity<Student> getStudent(@RequestParam String studentName) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findBySurname(studentName));
    }

    @GetMapping("/allStudents")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findAll());
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.save(student));
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long studentId) {
        studentService.delete(studentId);
        return ResponseEntity.noContent().build();
    }
}
