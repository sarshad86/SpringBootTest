VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} SpringBootTest-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/SpringBootTest-1.0-SNAPSHOT.jar"]