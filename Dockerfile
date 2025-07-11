FROM maven:3.9.4-eclipse-temurin-17-alpine
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests
CMD ["java", "-jar", "target/bankapp-0.0.1-SNAPSHOT.jar"]

