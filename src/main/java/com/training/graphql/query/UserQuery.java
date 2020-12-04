package com.training.graphql.query;

import com.training.graphql.entity.User;
import graphql.annotations.GraphQLField;
import graphql.annotations.GraphQLName;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;
import java.util.List;

import static com.training.graphql.storage.UserStorage.userDB;
import static java.lang.Long.parseLong;
import static java.util.stream.Collectors.toList;

@SuppressWarnings("unused")
@Slf4j
@GraphQLName("query")
public class UserQuery {

    @GraphQLField
    public static User retrieveUser(DataFetchingEnvironment env,
                                    @NotNull @GraphQLName("id") String id) {
        log.info("retrieveUser query is called");
        return userDB.get(parseLong(id));
    }

    @GraphQLField
    public static List<User> searchName(DataFetchingEnvironment env,
                                        @NotNull @GraphQLName("name") String name) {
        log.info("searchName query is called");
        return userDB.values().stream()
                .filter(user -> user.getName().contains(name))
                .collect(toList());
    }

    @GraphQLField
    public static List<User> listUsers(DataFetchingEnvironment env) {
//        return getUsers(env);
        return null;
    }

}
