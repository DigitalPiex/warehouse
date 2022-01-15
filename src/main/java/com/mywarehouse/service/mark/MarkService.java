package com.mywarehouse.service.mark;

import com.mywarehouse.entity.Mark;

public interface MarkService {
    Mark findById(Long id);

    Mark save(Mark mark);
}
