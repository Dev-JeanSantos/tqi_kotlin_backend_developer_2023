FROM openjdk:17-oracle
EXPOSE 8080
ADD /target/marketplace-0.0.1-SNAPSHOT.jar marketplace.jar
ENTRYPOINT ["java", "$JAVA_OPTS -XX:+UseContainerSupport", "-Xmx300m -Xss512k -XX:CICompilerCount=2", "-Dserver.port=$PORT", "-Dspring.profiles.active=prod","-jar","adopet.jar"]