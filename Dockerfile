FROM amazoncorretto:21-alpine

LABEL authors="william"

WORKDIR /app

COPY target/Clima-api-0.0.1-SNAPSHOT.jar app.jar

CMD ["java","-jar","/app/app.jar"]