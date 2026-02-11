FROM openjdk:26-trixie
COPY /target/Ecom-app.jar Ecom-app.jar
ENTRYPOINT ["java","-jar","/Ecom-app.jar"]