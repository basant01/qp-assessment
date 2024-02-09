FROM adoptopenjdk:17.0.9_12-jdk-hotspot
VOLUME /tmp
EXPOSE 8080
COPY target/booking-0.0.1-SNAPSHOT.jar booking.jar
ENTRYPOINT ["java","-jar","/booking.jar"]