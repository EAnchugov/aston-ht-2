package com.example.astonht2.attendance.model;

import com.example.astonht2.student.model.Student;
import com.example.astonht2.works.model.Work;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id")
    private Student student;

    @OneToOne
    @JoinColumn(name = "id")
    private Work work;

    private String present;
}
