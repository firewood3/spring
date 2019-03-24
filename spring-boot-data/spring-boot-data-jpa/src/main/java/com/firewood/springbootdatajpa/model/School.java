package com.firewood.springbootdatajpa.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class School {
    @Id
    @Column(name = "SCHOOL_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "SCHOOL_NAME")
    private String name;
    private String address;

    @OneToMany(mappedBy = "school")
//    @OneToMany
    private List<Student> students;

    public School(String name) {
        this.name = name;
    }
}
