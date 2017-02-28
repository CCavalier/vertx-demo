package io.vertx.codingame;

import io.vertx.core.Vertx;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import io.vertx.ext.web.client.WebClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
@RunWith(VertxUnitRunner.class)
public class ServerTest {

  private Vertx vertx;

  @Before
  public void before() {
    vertx = Vertx.vertx();
  }

  @After
  public void after(TestContext ctx) {
    vertx.close(ctx.asyncAssertSuccess());
  }

  @Test
  public void testOK(TestContext ctx) throws Exception {
    WebClient client = WebClient.create(vertx);
    vertx.deployVerticle(Server.class.getName(), ctx.asyncAssertSuccess(v -> {
      client.get(8080, "localhost", "/").send(ctx.asyncAssertSuccess(resp -> {
        ctx.assertEquals(200, resp.statusCode());
        ctx.assertEquals("OK", resp.bodyAsString());
      }));
    }));
  }
}
