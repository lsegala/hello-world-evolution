package br.com.lsegala.helloworld.action;

import br.com.lsegala.helloworld.HelloMicroservice;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(VertxUnitRunner.class)
public class HelloMicroserviceTest {
    private Vertx vertx;
    private int port = 8080;

    @Before
    public void setUp(TestContext context) throws IOException {
        vertx = Vertx.vertx();
        DeploymentOptions options = new DeploymentOptions()
                .setConfig(new JsonObject().put("http.port", port)
                );
        vertx.deployVerticle(HelloMicroservice.class.getName(), options, context.asyncAssertSuccess());
    }

    @Test
    public void testWithNoArgs(TestContext context) {
        final Async async = context.async();
        vertx.createHttpClient().getNow(port, "localhost", "/hello/", response -> {
            response.handler(body -> {
                JsonObject entity = body.toJsonObject();
                context.assertTrue(entity != null && entity.containsKey("message"));
                context.assertEquals("Hello!", entity.getString("message"));
                async.complete();
            });
        });
    }

    @Test
    public void testWithArgs(TestContext context) {
        final Async async = context.async();
        vertx.createHttpClient().getNow(port, "localhost", "/hello/Leonardo", response -> {
            response.handler(body -> {
                JsonObject entity = body.toJsonObject();
                context.assertTrue(entity != null && entity.containsKey("message"));
                context.assertEquals("Hello, Leonardo!", entity.getString("message"));
                async.complete();
            });
        });
    }

    @After
    public void tearDown(TestContext context) {
        vertx.close(context.asyncAssertSuccess());
    }
}
