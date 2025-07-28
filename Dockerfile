FROM eclipse-temurin:17

LABEL maintainer="www.github.com/jiraiyasuman"

WORKDIR /app

COPY target/guljo-0.0.1-SNAPSHOT.jar /app/guljo-spring.jar

ENTRYPOINT [ "java","-jar","guljo-spring.jar" ]
