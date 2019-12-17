FROM openjdk:11
MAINTAINER Rodrigo Pires
COPY ./build/libs/  /var/www
ENTRYPOINT [ "java", "-jar", "crud-0.0.1-SNAPSHOT.jar" ]
EXPOSE 8080:8080
WORKDIR /var/www