
FROM openjdk:17-jdk-alpine
COPY ./target/demo-0.0.1-SNAPSHOT.jar /sprintboot/docker/ocean.jar

WORKDIR /sprintboot/docker
RUN sh -c 'touch ocean.jar'
ENTRYPOINT ["java","-jar","ocean.jar"]