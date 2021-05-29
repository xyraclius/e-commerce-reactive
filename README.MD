# E-Commerce Project Using Spring Boot Reactive
![Java](https://img.shields.io/badge/java-v1.8-E53935) ![Spring Boot](https://img.shields.io/badge/spring%20boot-v2.4.5-yellow) ![Maven](https://img.shields.io/badge/maven-v3.8.1-orange) ![Docker](https://img.shields.io/badge/docker-v20-blue) ![Last Commit](https://img.shields.io/github/last-commit/xyraclius/e-commerce-reactive/master) [![License](http://img.shields.io/:license-apache&nbsp;2.0-blueviolet)](http://www.apache.org/licenses/LICENSE-2.0.html)

This is a project from my udemy course that I've completed

Link: [Reactive Microservices with Spring WebFlux](https://www.udemy.com/course/spring-webflux/)   
Certificate:  
<img src="https://udemy-certificate.s3.amazonaws.com/image/UC-73892af3-5ff3-47f1-97b6-ee4f72763465.jpg" alt="Certificate" width="550"/>
****

## Requirements

For building and running the application you need:
- [JDK 1.8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
- [Maven 3](https://maven.apache.org)
- [Docker 20](https://www.docker.com/products/docker-desktop)

## Running the applications locally

1. Go to folder of parent project
2. Run `docker-compose up -d`
3. In MySQL, Create database name: ecommerce
4. Create tables and insert dummy data using this file: user-service/src/main/resources/init.sql, into MySQL console
5. Run `mvn clean package`   
6. Run every service from main class from your IDE or alternatively [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so: `mvn spring-boot:run`

User Service Postman Collection : [![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/d440ed25d461603458ed)  
Product Service Postman Collection : [![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/5b1c3b3b51dfcbac004a)  
Order Service Postman Collection : [![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/a06882279cf1cc121f63)


## Copyright

Released under the Apache License 2.0. See the [LICENSE](LICENSE.MD) file.


## Contact
Nabil Fawwaz Elqayyim - [@xyraclius](https://instagram.com/xyraclius) - master@nabilfawwaz.com
