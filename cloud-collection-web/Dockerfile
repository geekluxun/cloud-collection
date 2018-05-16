FROM java:8
ADD target/cloud-collection-web.war app.war
RUN bash -c 'touch app.war'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.war"]