# My First Verticle

@[Vertx example]({"stubs":["/src/main/java/io/vertx/codingame/Server.java"],"command":"io.vertx.codingame.ServerTest#testOK"})

The class extends AbstractVerticle. In the Vert.x world, a verticle is a component. By extending AbstractVerticle, our class gets access to the vertx field.

The start method is called when the verticle is deployed. We could also implement a stop method, but in this case Vert.x takes care of the garbage for us. The start method receives a Future object that will let us inform Vert.x when our start sequence is completed or report an error. One of the particularity of Vert.x is its asynchronous / non-blocking aspect. When our verticle is going to be deployed it won’t wait until the start method has been completed. So, the Future parameter is important to notify of the completion.

The start method creates a HTTP server and attaches a request handler to it. The request handler is a lambda, passed in the requestHandler method, called every time the server receives a request. Here, we just reply Hello ... (nothing fancy I told you). Finally, the server is bound to the 8080 port. As this may fails (because the port may already be used), we pass another lambda expression checking whether or not the connection has succeeded. As mentioned above it calls either fut.complete in case of success or fut.fail to report an error.
