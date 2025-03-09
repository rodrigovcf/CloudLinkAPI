# Usando uma imagem do OpenJDK 21
FROM openjdk:21-jdk-slim

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo JAR gerado pelo Gradle para o container
COPY build/libs/CloudLinkAPI-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta usada pela API
EXPOSE 8080

# Comando para rodar a aplicação com as opções de memória e threads da JVM
CMD ["java", "-Xmx256m", "-Xms256m", "-XX:MaxMetaspaceSize=128m", "-XX:ReservedCodeCacheSize=64m", "-XX:ThreadStackSize=512k", "-jar", "app.jar"]

