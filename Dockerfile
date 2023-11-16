FROM openjdk:8.0
EXPOSE 8080
ADD target/order-service.jar order-service.jar
ENTRYPOINT ["java","-jar","/order-service.jar"]