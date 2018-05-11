FROM java:8
VOLUME /tmp
ADD cloud-collection-web.war app.war
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.war"]