FROM amazoncorretto:17-alpine-jdk
LABEL authors="Bhaskar"
copy target/*.jar patient.jar
ENTRYPOINT ["java", "-jar","/patient.jar"]