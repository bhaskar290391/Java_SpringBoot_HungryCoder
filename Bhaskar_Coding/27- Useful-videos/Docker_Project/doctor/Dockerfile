FROM amazoncorretto:17-alpine-jdk
LABEL authors="Bhaskar"
copy target/*.jar doctor.jar
ENTRYPOINT ["java", "-jar","/doctor.jar"]