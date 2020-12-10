package com.training.graphql;

import com.training.graphql.handler.UserHandler;
import ratpack.server.RatpackServer;

public class Application {

    public static void main(String[] args) throws Exception {
        RatpackServer ratpackServer = RatpackServer.of(server ->
                server.handlers(chain -> chain.post("users", new UserHandler())));
        ratpackServer.start();
    }
}
