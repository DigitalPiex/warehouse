package com.mywarehouse.service.mark;

import com.mywarehouse.entity.Mark;
import com.mywarehouse.repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MarkServiceImpl implements MarkService {

    MarkRepository markRepository;

    @Autowired
    public MarkServiceImpl(MarkRepository markRepository) {
        this.markRepository = markRepository;
    }

    @Override
    public Mark findById(Long id) {
        return markRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Mark save(Mark mark) {
        return markRepository.save(mark);
    }
}
