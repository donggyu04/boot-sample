package com.training.graphql.mutation;

import com.training.graphql.entity.User;
import graphql.annotations.GraphQLField;
import graphql.annotations.GraphQLName;
import graphql.schema.DataFetchingEnvironment;

import javax.validation.constraints.NotNull;
import java.util.NoSuchElementException;

import static com.training.graphql.storage.UserStorage.userDB;
import static java.lang.Long.parseLong;

@SuppressWarnings("unused")
@GraphQLName("mutation")
public class UserMutation {

    @GraphQLField
    public static User createUser(DataFetchingEnvironment env,
                                  @NotNull @GraphQLName("name") String name,
                                  @NotNull @GraphQLName("email") String email) {
        User newUser = new User(name, email);
        userDB.put(newUser.getId(), newUser);
        return newUser;
    }

    @GraphQLField
    public static User updateUser(final DataFetchingEnvironment env,
                                  @NotNull @GraphQLName("id") String id,
                                  @NotNull @GraphQLName("name") final String name,
                                  @NotNull @GraphQLName("email") final String email) {
        User user = userDB.get(parseLong(id));
        if (user == null) {
            throw new NoSuchElementException("User id[" + id + "] is not exist.");
        }

        user.setName(name);
        user.setEmail(email);
        return user;
    }

    @GraphQLField
    public static User deleteUser(final DataFetchingEnvironment env,
                                  @NotNull @GraphQLName("id") String id) {
        User result = userDB.remove(parseLong(id));
        if (result == null) {
            throw new NoSuchElementException("User id[" + id + "] is not exist.");
        }

        return result;
    }
}
