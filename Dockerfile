FROM amazoncorretto:17
ADD target/spring-cloud-aws-sqs-0.0.1-SNAPSHOT.jar sample.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","sample.jar"]