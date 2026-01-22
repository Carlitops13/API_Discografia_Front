# Build stage - Compilar la aplicación
FROM maven:3.8.1-openjdk-17 AS builder

WORKDIR /build

# Copiar archivos de configuración
COPY pom.xml .

# Descargar dependencias
RUN mvn dependency:go-offline

# Copiar código fuente
COPY src ./src

# Compilar la aplicación
RUN mvn clean package -DskipTests

# Runtime stage - Imagen final
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copiar el JAR compilado desde el stage anterior
COPY --from=builder /build/target/*.jar app.jar

# Exponer puerto
EXPOSE 8080

# Variables de entorno
ENV JAVA_OPTS="-Xmx512m -Xms256m"

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
