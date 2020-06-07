FROM java:8
ADD dev-v1.0.jar app.jar
VOLUME /tmp
ENTRYPOINT ["java","-jar","app.jar","--server.port=8080"]