package com.mywarehouse.repository;

import com.mywarehouse.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
