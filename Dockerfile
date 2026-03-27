FROM amazoncorretto:21-alpine AS build

WORKDIR /app

COPY .mvn/ .mvn

COPY pom.xml ./

COPY mvnw ./

RUN ./mvnw dependency:go-offline

COPY src ./src

RUN ./mvnw package -DskipTests

FROM amazoncorretto:21-alpine

LABEL authors="william"

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

CMD ["java","-jar","app.jar"]

