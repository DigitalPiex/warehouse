package com.mywarehouse.service.mark;

import com.mywarehouse.entity.Mark;
import com.mywarehouse.entity.Student;
import com.mywarehouse.entity.Subject;
import com.mywarehouse.repository.MarkRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MarkServiceTest {

    MarkServiceImpl markService;

    @Mock
    MarkRepository markRepository;

    @BeforeEach
    void setUp() {
        markService = new MarkServiceImpl(markRepository);
    }

    @Test
    void findById() {
        Mark markMock = new Mark(1L, 5, new Student(), new Subject());
        when(markRepository.findById(anyLong())).thenReturn(Optional.of(markMock));
        Mark markById = markService.findById(1L);
        assertThat(markById).isNotNull();
        assertThat(markById.getId()).isEqualTo(1L);
        assertThat(markById.getValue()).isEqualTo(5);
        assertThat(markById.getStudent()).isEqualTo(new Student());
        assertThat(markById.getSubject()).isEqualTo(new Subject());
    }

    @Test
    void findAll() {
        Mark markMock1 = new Mark(1L, 5, new Student(), new Subject());
        Mark markMock2 = new Mark(2L, 4, new Student(), new Subject());
        List<Mark> markMockList = new ArrayList<>();
        markMockList.add(markMock1);
        markMockList.add(markMock2);
        when(markRepository.findAll()).thenReturn(markMockList);
        List<Mark> markList = markService.findAll();
        assertThat(markList).isNotNull().isNotEmpty();
        assertThat(markList).size().isEqualTo(2);
    }
}