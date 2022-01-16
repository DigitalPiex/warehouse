package com.mywarehouse.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Pattern(regexp="[a-zA-Z]")
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "subjects")
    private List<Student> students;

    @OneToMany(mappedBy = "subject")
    private List<Mark> marks;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return Objects.equals(id, subject.id) && Objects.equals(name, subject.name) && Objects.equals(students, subject.students) && Objects.equals(marks, subject.marks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, students, marks);
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students=" + students +
                ", marks=" + marks +
                '}';
    }
}