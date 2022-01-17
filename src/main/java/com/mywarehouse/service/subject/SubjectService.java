package com.mywarehouse.service.subject;

import com.mywarehouse.entity.Subject;

import java.util.List;

public interface SubjectService {
    Subject findById(Long id);

    List<Subject> findAll();

    Subject save(Subject subject);

    void delete(Long id);
}
