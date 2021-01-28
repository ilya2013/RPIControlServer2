#FROM openjdk:11-jdk-alpine
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]

#FROM adoptopenjdk/openjdk11:jdk-11.0.5_10-alpine
#ADD . /src
#WORKDIR /src
#RUN ./mvnw package -DskipTests
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","target/RPIControlServer-0.0.1-SNAPSHOT.jar"]

FROM adoptopenjdk/openjdk11:jdk-11.0.5_10-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]