# Temel imaj
FROM eclipse-temurin:17-jdk

# Çalışma dizini oluştur
WORKDIR /app

# Maven wrapper dosyalarını ve pom.xml'i kopyala
COPY .mvn/ .mvn
COPY mvnw .
COPY pom.xml .

# Bağımlılıkları indir
RUN ./mvnw dependency:go-offline

# Tüm kaynakları kopyala
COPY . .

# Projeyi build et
RUN ./mvnw clean package -DskipTests

# Uygulamayı çalıştır
CMD ["java", "-jar", "target/*.jar"]
