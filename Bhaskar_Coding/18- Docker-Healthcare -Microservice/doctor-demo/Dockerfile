FROM amazoncorretto:21-alpine-jdk
COPY target/*.jar doctor-demo.jar
ENTRYPOINT [ "java","-jar","/doctor-demo.jar" ]