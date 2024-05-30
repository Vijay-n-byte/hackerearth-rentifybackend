FROM openjdk:17
EXPOSE 8080
ADD target/Hackerearth-0.0.1-SNAPSHOT.jar Hackerearth-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","Hackerearth-0.0.1-SNAPSHOT.jar"]