package com.mywarehouse.service.mark;

import com.mywarehouse.entity.Mark;

import java.util.List;

public interface MarkService {
    Mark findById(Long id);

    List<Mark> findAll();

    Mark save(Mark mark);

    void delete(Long id);
}
