package com.mywarehouse.restcontroller;

import com.mywarehouse.entity.Mark;
import com.mywarehouse.service.mark.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mark/v1")
public class MarkController {

    private final MarkService markService;

    @Autowired
    public MarkController(MarkService markService) {
        this.markService = markService;
    }

    @GetMapping("/{markId}")
    public ResponseEntity<Mark> getMark(@PathVariable Long markId) {
        return ResponseEntity.status(HttpStatus.OK).body(markService.findById(markId));
    }

    @GetMapping("/allMarks")
    public ResponseEntity<List<Mark>> getAllMarks() {
        return ResponseEntity.status(HttpStatus.OK).body(markService.findAll());
    }

    @PostMapping
    public ResponseEntity<Mark> addMark(@RequestBody Mark mark) {
        return ResponseEntity.status(HttpStatus.OK).body(markService.save(mark));
    }

    @DeleteMapping("/{markId}")
    public ResponseEntity<Void> deleteMark(@PathVariable Long markId) {
        markService.delete(markId);
        return ResponseEntity.noContent().build();
    }
}
