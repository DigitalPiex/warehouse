package com.mywarehouse;

import com.mywarehouse.entity.Mark;
import com.mywarehouse.repository.MarkRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.crossstore.ChangeSetPersister;

@SpringBootApplication
public class MyWarehouseApplication {

    final MarkRepository markRepository;

    public MyWarehouseApplication(MarkRepository markRepository) {
        this.markRepository = markRepository;
    }

    public void asd(Long id) throws ChangeSetPersister.NotFoundException {
        markRepository.save(new Mark(5));
        Mark mark = markRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
        mark.setValue(34);
        markRepository.save(mark);
		markRepository.findById(43L);
    }

    public static void main(String[] args) {
        SpringApplication.run(MyWarehouseApplication.class, args);
    }

}
