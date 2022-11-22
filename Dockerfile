FROM maven:3.8.5-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean install

FROM openjdk:11
COPY --from=build /home/app/target/kvstore-maven-1.0-SNAPSHOT-jar-with-dependencies.jar kvstore-maven.jar
ENTRYPOINT ["java","-jar","/kvstore-maven.jar"]
EXPOSE 26658