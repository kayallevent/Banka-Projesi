FROM openjdk:17
WORKDIR /app
COPY . .
RUN chmod +x mvnw && ./mvnw clean package -DskipTests
CMD ["java", "-jar", "target/bankapp-0.0.1-SNAPSHOT.jar"]
