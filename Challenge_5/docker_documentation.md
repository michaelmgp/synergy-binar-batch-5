# Docker Documentation

## Intro
This tutorial is meant to guide a beginner developer to build a docker image, run a container, and 
manually deploy into AWS Cloud with a free tier EC2-instance

### Presequites
- A favorite text editor or IDE
-  [JDK 1.8](https://www.oracle.com/java/technologies/downloads/) or later
- Maven 3.2+
- AWS Active account 
- Download and Install dockern

### Run Docker in EC2-server
first run the postgresSQL Images. A running images as same as a container
```
docker run --name postgresql -p 5432:5432 POSTGRES_PASSWORD={YOUR PASSWORD} -d {YOUR USERNAME}
```
run this command to login into PostgreSQL Container
```
docker exec -it 05b3a3471f6f bash
root@05b3a3471f6f:/# psql -U postgres
postgres-# CREATE DATABASE mytest;
```
run your docker image from your docker repo and dont forget
to add the port for your application and server

```
docker run --name app_docker -p 80:8080 -d michaelmgp/challenge-5:v2
```