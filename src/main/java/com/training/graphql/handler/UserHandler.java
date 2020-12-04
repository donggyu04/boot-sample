package com.training.graphql.handler;

import com.training.graphql.entity.User;
import com.training.graphql.schema.UserSchema;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.training.graphql.storage.UserStorage.userDB;
import static graphql.GraphQL.newGraphQL;
import static ratpack.jackson.Jackson.json;

@Slf4j
public class UserHandler implements Handler {

    private final GraphQL graphql;

    public UserHandler() throws Exception {
        graphql = newGraphQL(new UserSchema().getGraphQLSchema()).build();
    }

    @Override
    public void handle(Context context) throws Exception {
        context.parse(Map.class)
                .then(payload -> {
                    Map<String, Object> parameters = (Map<String, Object>) payload.get("parameters");
                    ExecutionResult executionResult = graphql.execute(payload.get("query")
                            .toString(), null, this, parameters);
                    Map<String, Object> result = new LinkedHashMap<>();

                    if (executionResult.getErrors().isEmpty()) {
                        result.put("data", executionResult.getData());
                    } else {
                        result.put("errors", executionResult.getErrors());
                        log.warn("Errors: " + executionResult.getErrors());
                    }

                    context.render(json(result));
                });
    }

    public static List<User> getUsers() {
        return (List<User>) userDB.values();
    }

    public static List<User> getUsers(DataFetchingEnvironment env) {
        return ((UserHandler) env.getSource()).getUsers();
    }
}
