### COSC2299 - Semester 2 2022

# MDOnline

### Contributors:
- Nathan Boc - s3717205
- Mevlut Saluk - s3717696
- Christodoulos Voulismas - s3850105
- Abida Mohammadi - s3811920
- Sankeath Suriya Arachchiralalage - s3897982

# Backend Services
### Requirements

For building and running the application you need:

- [JDK 17](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

### Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:


```shell
mvn spring-boot:run
```

# Dockerising Backend Services

## Building with Docker

### Using the latest image

This can be ignored as GitHub Actions will create a new Jar file on each push(or release) to main.

### Instructions on containerising all services

1. Pull code
2. Navigate to the compose file which is found in __Backend__ Folder
3. You may need to change the database password in the compose file
4. Each service has its own DockerFile
5. To run all these services, run the following command once navigated to the __Backend__ Folder:

  ```shell
    docker compose up
  ```
6. This will containerise all backend services and the database.

# Frontend Services
### Requirements



For running the flutter application you will need:





- [JDK 17](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Google Chrome](https://www.google.com/intl/en_au/chrome/)
- [Flutter](https://docs.flutter.dev/get-started/install?gclid=Cj0KCQjwnbmaBhD-ARIsAGTPcfXixsuYpUsxCGaPS3SP9KJ1Yuyh3sgC785ncj8gk5qhqEK1d-DnuNYaAqqHEALw_wcB&gclsrc=aw.ds)
- CLI (Command-Line Interface) such as [Gitbash](https://git-scm.com/downloads), Powershell, etc.




### Running the application



1. Pull code



2. Ensure the backend services are running



3. Open your CLI and change the current directory to "./SEPT2022/Frontend/telemedicine_flutter"



4. Run the following command to execute the Flutter application. (Note that running this application may take a while to load)




```shell
flutter run -d Chrome
```
