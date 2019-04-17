package br.com.lsegala.helloworld;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

public class HelloMicroservice extends AbstractVerticle {

    @Override
    public void start() {
        Router router = Router.router(vertx);

        router.route().handler(BodyHandler.create());
        router.get("/hello/").handler(this::handleHelloWorld);
        router.get("/hello/:name").handler(this::handleHelloWorld);

        vertx.createHttpServer().requestHandler(router::accept).listen(8080);
    }

    private void handleHelloWorld(RoutingContext rc){
        String name = rc.request().getParam("name");
        JsonObject entity = new JsonObject()
                .put("message", "Hello" + (name != null? ", "+name : "") + "!");
        rc.response()
                .putHeader("content-type", "application/json")
                .end(entity.encodePrettily());
    }

}
