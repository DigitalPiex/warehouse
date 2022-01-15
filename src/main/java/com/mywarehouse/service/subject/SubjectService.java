package com.mywarehouse.service.subject;

import com.mywarehouse.entity.Subject;

import java.util.List;

public interface SubjectService {
    Subject findSubjectById(Long id);
    
    Subject findSubjectByName(String name);

    List<Subject> findAllSubjects();

    Subject saveSubject(Subject subject);

    void updateSubject(Long id, Subject subject);

    void deleteSubject(Long id);
}
