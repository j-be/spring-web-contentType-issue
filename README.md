# Minimal reproducer for https://github.com/spring-projects/spring-framework/issues/32363

## Steps to reproduce

1. `./gradlew build` -> fails
2. Go to [build.gradle.kts](./build.gradle.kts) and uncomment the downgrade of `spring-web` to `6.1.3` [here](./build.gradle.kts#L24)
3. `./gradlew build` -> succeeds

## Background

As I don't know how I would force HTTP streaming, I created [DisableContentCachingFilter](./src/main/java/org/duckdns/owly/spring/issues/DisableContentCachingFilter.java) to manually invoke `ShallowEtagHeaderFilter.disableContentCaching(request);`.
This is normally done when HTTP streaming is used (see [here](https://github.com/spring-projects/spring-framework/blob/v6.1.4/spring-webmvc/src/main/java/org/springframework/web/servlet/mvc/method/annotation/ResponseBodyEmitterReturnValueHandler.java#L168) and [here](https://github.com/spring-projects/spring-framework/blob/main/spring-webmvc/src/main/java/org/springframework/web/servlet/mvc/method/annotation/StreamingResponseBodyReturnValueHandler.java#L87)).
