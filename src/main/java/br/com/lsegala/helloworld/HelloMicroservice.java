package br.com.lsegala.helloworld;

import io.vertx.core.AbstractVerticle;

public class HelloMicroservice extends AbstractVerticle {

    @Override
    public void start() {
        vertx.createHttpServer()
                .requestHandler(req -> req.response().end("Hello, World!"))
                .listen(8080);
    }

}
