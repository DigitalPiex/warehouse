package com.mywarehouse.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "mark")
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Min(2)
    @Max(5)
    @Column(name = "value")
    private int value;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    public Mark(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mark mark = (Mark) o;
        return value == mark.value && Objects.equals(id, mark.id) && Objects.equals(student, mark.student) && Objects.equals(subject, mark.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, student, subject);
    }

    @Override
    public String toString() {
        return "Mark{" +
                "id=" + id +
                ", value=" + value +
                ", student=" + student +
                ", subject=" + subject +
                '}';
    }
}
