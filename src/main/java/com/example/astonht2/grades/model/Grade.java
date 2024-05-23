package com.example.astonht2.grades.model;

import com.example.astonht2.student.model.Student;
import com.example.astonht2.works.model.Work;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "grades")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id")
    private Student student;
    @OneToOne
    @JoinColumn(name = "id")
    private Work work;
    private Long grade;
}
