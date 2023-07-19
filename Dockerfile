#
# Build stage
#
FROM maven:3.9.3-eclipse-temurin-17-alpine AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM eclipse-temurin:17-jdk-alpine
COPY --from=build /home/app/target/*.jar /usr/local/lib/app.jar
EXPOSE 80
ENTRYPOINT ["java","-jar","/usr/local/lib/app.jar"]
