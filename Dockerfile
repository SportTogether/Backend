FROM openjdk:11-jdk-slim
#ARG JAR_FILE=target/*jar
COPY --from=build /target/demo-0.0.1-SNAPSHOT.jar app.jar
ENV PORT=8080
#EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]