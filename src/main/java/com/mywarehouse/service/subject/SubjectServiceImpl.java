package com.mywarehouse.service.subject;

import com.mywarehouse.entity.Subject;
import com.mywarehouse.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    SubjectRepository subjectRepository;

    @Autowired
    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Subject findSubjectById(Long id) {
        return null;
    }

    @Override
    public Subject findSubjectByName(String name) {
        return null;
    }

    @Override
    public List<Subject> findAllSubjects() {
        return null;
    }

    @Override
    public Subject saveSubject(Subject subject) {
        return null;
    }

    @Override
    public void updateSubject(Long id, Subject subject) {

    }

    @Override
    public void deleteSubject(Long id) {

    }
}
