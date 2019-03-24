package com.firewood.springbootdatajpa.model;

import com.firewood.springbootdatajpa.model.type.MemberRole;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "tbl_member")
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "age", length = 100)
    private Integer age;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private MemberRole role;
    @Column(name = "createdAt")
    private Date createdAt;

    public Member(String name, Integer age, MemberRole role) {
        this.name = name;
        this.age = age;
        this.role = role;
    }

    @PrePersist
    public void beforeCreate() {
        createdAt = new Date();
    }
}
