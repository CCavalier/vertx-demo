package io.vertx.codingame;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpServer;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class Server extends AbstractVerticle {

  @Override
  public void start(Future<Void> startFuture) throws Exception {

    HttpServer server = vertx.createHttpServer();

    server.requestHandler(req -> {
      req.response().end("OK");
    });

    server.listen(8080, ar -> {
      startFuture.completer().handle(ar.map((Void)null));
    });

  }
}
