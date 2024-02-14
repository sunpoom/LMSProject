FROM amazoncorretto:17

WORKDIR /app

COPY build/libs/LMSProject-1.0-SNAPSHOT.jar /app/application.jar

EXPOSE 80

CMD ["java", "-jar", "application.jar"]