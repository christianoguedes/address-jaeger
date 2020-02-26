FROM adoptopenjdk/openjdk11:alpine-jre

COPY ./target/microservice-addres*.jar /app/app.jar

CMD ["java", "-jar", "/app/app.jar"]