FROM maven:latest as builder
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn package -DskipTests


FROM tomcat
WORKDIR /app

COPY --from=builder /app/target/Spring-0.0.1-SNAPSHOT.jar .

EXPOSE 8888

ENTRYPOINT ["java","-jar","Spring-0.0.1-SNAPSHOT.jar"]
