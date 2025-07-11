FROM openjdk:17

WORKDIR /app
COPY . .

# ⬇️ mvnw'yi çalıştırılabilir hale getir
RUN chmod +x mvnw

# ⬇️ mvnw ile build et
RUN ./mvnw clean package -DskipTests

# Uygulamayı başlat
CMD ["java", "-jar", "target/bankapp-0.0.1-SNAPSHOT.jar"]

