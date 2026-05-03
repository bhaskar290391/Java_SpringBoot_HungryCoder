FROM amazoncorretto:21-alpine-jdk
COPY target/*.jar patient-demo.jar
ENTRYPOINT [ "java","-jar","/patient-demo.jar" ]