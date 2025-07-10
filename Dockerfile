FROM eclipse-temurin:17-jdk-alpine

# Çalışma dizinini oluştur
WORKDIR /app

# Maven Wrapper dosyalarını kopyala
COPY bankapp/.mvn .mvn
COPY bankapp/mvnw .
COPY pom.xml .

# Bağımlılıkları indir
RUN ./mvnw dependency:go-offline

# Kaynak kodları kopyala
COPY bankapp/src ./src

# Build et
RUN ./mvnw clean package -DskipTests

# Uygulamayı çalıştır
CMD ["java", "-jar", "target/*.jar"]
