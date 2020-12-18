FROM openjdk:12
WORKDIR /
ADD build/libs/Online-workshop-beatrice-1.0-SNAPSHOT-all.jar online-webshop.jar
EXPOSE 9000
ENTRYPOINT ["java", "-jar", "online-webshop.jar"]