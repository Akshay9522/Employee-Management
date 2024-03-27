FROM openjdk:17
WORKDIR /app
MAINTAINER Akshay Shinde
COPY ./target/userRegistration-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
CMD ["java", "-jar", "userRegistration-0.0.1-SNAPSHOT.jar"]