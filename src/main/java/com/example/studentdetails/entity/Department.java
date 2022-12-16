package com.example.studentdetails.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="department")
@Setter@Getter
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private long dept_id;
 //   @Column(name="stu_dept")
    @NonNull

    private String dept;

//    @OneToMany(mappedBy = "department")
//    private List<StudentEntity> studentEntity;

    public Department(long dept_id, String dept) {
        this.dept_id = dept_id;
        this.dept = dept;
    }

    public Department() {

    }
    //    @ManyToOne(targetEntity = StudentEntity.class, cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    private StudentEntity studentEntityList;

}
