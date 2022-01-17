package com.mywarehouse.restcontroller;

import com.mywarehouse.entity.Subject;
import com.mywarehouse.service.subject.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("subject/v1")
public class SubjectController {

    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/{subjectId}")
    public ResponseEntity<Subject> getSubject(@PathVariable Long subjectId) {
        return ResponseEntity.status(HttpStatus.OK).body(subjectService.findById(subjectId));
    }

    @GetMapping("/allSubjects")
    public ResponseEntity<List<Subject>> getAllSubjects() {
        return ResponseEntity.status(HttpStatus.OK).body(subjectService.findAll());
    }

    @PostMapping
    public ResponseEntity<Subject> addSubject(@RequestBody Subject subject) {
        return ResponseEntity.status(HttpStatus.OK).body(subjectService.save(subject));
    }

    @DeleteMapping("/{subjectId}")
    public ResponseEntity<Void> deleteSubject(@PathVariable Long subjectId) {
        subjectService.delete(subjectId);
        return ResponseEntity.noContent().build();
    }
}
