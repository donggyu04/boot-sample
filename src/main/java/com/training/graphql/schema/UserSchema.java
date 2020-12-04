package com.training.graphql.schema;

import com.training.graphql.mutation.UserMutation;
import com.training.graphql.query.UserQuery;
import graphql.schema.GraphQLSchema;
import lombok.Getter;

import static graphql.annotations.GraphQLAnnotations.object;
import static graphql.schema.GraphQLSchema.newSchema;

@Getter
public class UserSchema {

    private final GraphQLSchema graphQLSchema;

    public UserSchema() {
        graphQLSchema = newSchema()
                .query(object(UserQuery.class))
                .mutation(object(UserMutation.class))
                .build();
    }
}
