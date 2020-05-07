package com.training.bootsample.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "MEMBER")
@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AGE")
    private Integer age;
}