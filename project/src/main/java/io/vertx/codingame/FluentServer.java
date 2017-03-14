package io.vertx.codingame;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpServer;

/**
 * Created by charlotte on 02/03/17.
 */
public class FluentServer extends AbstractVerticle {

    /*
     * Return a text with Hello World
     */
    @Override
    public void start(Future<Void> startFuture) throws Exception {

        HttpServer server = vertx.createHttpServer();

        server.requestHandler(req -> {
            req.response().end("Ok");//complete here
        });

        server.listen(8080, ar -> {
            startFuture.completer().handle(ar.map((Void)null));
        });

    }

}
