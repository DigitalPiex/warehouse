package com.mywarehouse.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Pattern(regexp="[a-zA-Z]")
    @Column(name = "surname")
    private String surname;

    @OneToMany(mappedBy = "student")
    private List<Mark> marks;

    @ManyToMany(mappedBy = "students")
    private List<Subject> subjects = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(surname, student.surname) && Objects.equals(marks, student.marks) && Objects.equals(subjects, student.subjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, marks, subjects);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", marks=" + marks +
                ", subjects=" + subjects +
                '}';
    }
}