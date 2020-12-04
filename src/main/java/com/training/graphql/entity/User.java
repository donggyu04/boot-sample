package com.training.graphql.entity;

import graphql.annotations.GraphQLField;
import graphql.annotations.GraphQLName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicLong;

@Getter
@Setter
@ToString
@GraphQLName("user")
public class User {

    private static final AtomicLong idGenerator = new AtomicLong();

    public User(String name, String email) {
        id = idGenerator.incrementAndGet();
        this.name = name;
        this.email = email;
    }

    @GraphQLField
    private final Long id;

    @GraphQLField
    private String name;

    @GraphQLField
    private String email;
}
