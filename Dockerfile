FROM debian:stable-slim
RUN apt update && apt -y upgrade
RUN apt install -y openjdk-17-jdk maven
RUN apt clean
RUN rm -rf /var/lib/apt/lists/*
WORKDIR /app
# Copy app files
COPY . .

RUN mvn clean install

RUN #ls ./target
EXPOSE 8080
# java -jar /app/app.jar
ENTRYPOINT ["java","-jar","target/todoreminder-0.0.1-SNAPSHOT.jar"]
