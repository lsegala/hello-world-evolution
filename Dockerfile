FROM fabric8/java-alpine-openjdk8-jdk
ENV JAVA_APP_JAR demo-thorntail.jar
ENV JAVA_OPTIONS -Djava.net.preferIPv4Stack=true
ADD target/demo-thorntail.jar /deployments/