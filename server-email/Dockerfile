FROM maven:3.6-jdk-11
ADD . /cxfbootsimple
WORKDIR /cxfbootsimple
RUN mvn clean
RUN mvn package
FROM adoptopenjdk:11-jre-openj9
COPY --from=0 /cxfbootsimple/target/serveremail-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java","-jar", "/app.jar"]
CMD ["/resources"]