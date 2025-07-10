# Temel Java 17 image'i
FROM eclipse-temurin:17-jdk-alpine

# Uygulama dizinini oluştur
WORKDIR /app

# Maven wrapper dosyalarını kopyala (varsa)
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Maven bağımlılıklarını indir
RUN ./mvnw dependency:go-offline

# Tüm kaynak dosyaları kopyala
COPY . .

# Uygulama derleniyor
RUN ./mvnw clean package -DskipTests

# .jar dosyasını çalıştır
CMD ["java", "-jar", "target/*.jar"]
