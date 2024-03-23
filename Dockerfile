
# Establecer la imagen base
FROM adoptopenjdk/openjdk8:alpine-slim

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR de la aplicación al contenedor
COPY target/exam-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto en el que la aplicación se ejecuta dentro del contenedor
EXPOSE 8443

# Comando para ejecutar la aplicación al iniciar el contenedor
CMD ["java", "-jar", "app.jar"]
