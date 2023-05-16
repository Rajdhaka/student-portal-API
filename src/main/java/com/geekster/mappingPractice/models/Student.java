package com.geekster.mappingPractice.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,scope = Student.class,property = "studentId")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    private String studentName;

    private Integer studentAge;

    private String studentPhoneNumber;

    private String studentBranch;

    @Enumerated(EnumType.STRING)
    private Department studentDepartment;

    @OneToOne
    private Address studenaddress;

    @OneToOne()
    private Laptop laptop;

    @OneToMany()
    private List<Book>bookList;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Course> courseList;
}
