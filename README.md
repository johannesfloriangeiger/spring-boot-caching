Caching with Spring Boot
=

This is an example of how a Spring Boot application can use annotation based caching to avoid unnecessary calls to
services that are deemed cacheable.

Setup
-

Checkout the code and run

```
mvn clean install spring-boot:repackage
```

Run
-

```
java -jar target/api.jar
```

Run `curl localhost:8080/api/info` and you get the start time and uptime of the application as a response. The log shows
that the `org.example.InfoService` received two requests. If you repeat the same command, only one service call (the one
requesting the uptime) is being logged - because the start time is cached in the application scope, i.e. as long as the
application runs.

Run `curl -H "Content-Type: text/plain" -d "Hello World\!" localhost:8080/api/message` and you
get `HELLO WORLD! HELLO WORLD! HELLO WORLD!` as a response and the log states that the `org.example.MessageService`
received a single request to transform the message, even though that the controller calls the method three times -
because the result of the method is cached in the request scope, i.e. as long as the HTTP request runs. If you repeat
the same command, you get the same result and the same log message as the cache invalidates after each request.