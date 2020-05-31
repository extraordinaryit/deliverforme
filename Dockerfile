FROM openjdk:8
ADD target/deliverforme-0.0.1-SNAPSHOT.jar deliverforme-0.0.1-SNAPSHOT.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "deliverforme-0.0.1-SNAPSHOT.jar"]