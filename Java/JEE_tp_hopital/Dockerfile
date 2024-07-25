FROM maven:latest as builder
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn package -DskipTests

FROM tomcat:9.0-jdk11
WORKDIR /usr/local/tomcat/webapps/
COPY --from=builder /app/target/JEE_tp_hopital-1.0-SNAPSHOT.war .

EXPOSE 8080

CMD ["catalina.sh", "run"]
