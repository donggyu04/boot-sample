package com.training.graphql.storage;

import com.training.graphql.entity.User;

import java.util.HashMap;
import java.util.Map;

public class UserStorage {

    public static final Map<Long, User> userDB = new HashMap<>();

    static {
        for (long i = 0; i < 5; i++) {
            User newUser = new User("user" + i, "uesr" + i + "@test.com");
            userDB.put(newUser.getId(), newUser);
        }
    }
}
