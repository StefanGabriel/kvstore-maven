package com.pies.kvstore;

import jetbrains.exodus.env.Environment;
import jetbrains.exodus.env.Environments;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        try (Environment env = Environments.newInstance("/tendermint-data")) {
            var app = new KVStoreApp(env);
            var server = new GrpcServer(app, 26658);
            server.start();
            server.blockUntilShutdown();
        }
    }
}