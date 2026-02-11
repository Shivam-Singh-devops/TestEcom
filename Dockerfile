FROM openjdk:26-trixie
ADD /target/Ecom-app.jar Ecom-app.jar
ENTRYPOINT ["java","-jar","/Ecom-app.jar"]