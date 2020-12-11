package com.training.bootsample.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NgrinderParam {
    private String name;
    private int age;
    private List<String> alias;
    private InnerParam innerParam;
}
