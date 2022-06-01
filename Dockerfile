# java version
FROM java:8
# exposing the default port
EXPOSE 8080
#add a jar of a paticular target
ADD target/docker-demo.jar docker-demo.jar

ENTRYPOINT ["java", "-jar", "docker-demo.jar"]

#after this step we need to build our jar
