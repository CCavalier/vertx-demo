# Be fluent In Vert.x


With vertex you can use a fluent API. It means multiple methods calls can be chained together.
It make code a little bit less verbose.

Let's try to create de response to a request in plain text ("text/plain") who return "Hello world".
Be careful: the header size must be definer or chunked.
Don't forget to end your request !

@[One line it]({"stubs":["/src/main/java/io/vertx/codingame/FluentServer.java"],"command":"io.vertx.codingame.ServerTest#testFluent"})

