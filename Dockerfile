# Use a imagem oficial do Maven para construir o projeto
FROM maven:3.9.7-eclipse-temurin-21 as build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Verificar o conteúdo do diretório target para garantir que o JAR foi gerado
RUN ls -l target/

# Use uma imagem JDK para executar a aplicação
FROM eclipse-temurin:21-jre-jammy

# Definir ARG para versão do JAR
ARG JAR_FILE=target/api-0.0.1-SNAPSHOT.jar  # Atualize o nome do JAR aqui

# Definir ENV para configuração do banco de dados
ENV DB_HOST=oracle-db
ENV DB_PORT=1521
ENV DB_NAME=GLOBAL_FIAP
ENV DB_USER=RM552364
ENV DB_PASSWORD=180904

# Criar um usuário sem privilégios administrativos
RUN addgroup --system appgroup && adduser --system appuser --ingroup appgroup

# Definir o diretório de trabalho e copiar o JAR construído para o contêiner
WORKDIR /app
COPY --from=build /app/${JAR_FILE} app.jar
RUN chown -R appuser:appgroup /app

# Alterar o usuário para o usuário sem privilégios administrativos
USER appuser

# Expor a porta da aplicação
EXPOSE 5000

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]