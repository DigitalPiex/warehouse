package com.mywarehouse.repository;

import com.mywarehouse.entity.Mark;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkRepository extends CrudRepository<Mark, Long> {
}
