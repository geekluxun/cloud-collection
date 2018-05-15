FROM java:8
VOLUME /tmp
#ADD cloud-collection-web.war app.war
RUN bash -c 'touch /cloud-collection-web.war'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/cloud-collection-web.war"]