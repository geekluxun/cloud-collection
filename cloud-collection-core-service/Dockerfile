FROM java:8
ADD target/cloud-collection-core-service.jar app.jar
RUN bash -c 'touch app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]