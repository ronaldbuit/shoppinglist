# shoppinglist
Shopping list showcase project.
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=ronaldbuit_shoppinglist&metric=alert_status)](https://sonarcloud.io/dashboard?id=ronaldbuit_shoppinglist)
## Goal
Goal of this project is to use different frameworks and techniques. Used frameworks in this demo project are:
+ Back-end:
	+ Java
		+ Spring boot
		+ Hibernate
	+ Postgresql
+ Font-end:
	+ Angular
	+ Native script (to do)
+ Deployment:
	+ Maven
	+ Docker
	+ Sonar

Idea of the application is to create a shopping list, reuse this and share this with other users.
## Setup
Basically the application contains a web/app front-end with a REST API back-end (with Spring boot).
For generating getters and setters Lombok ([https://projectlombok.org/](https://projectlombok.org/)) is used.
## Install
You can install the Java part with Maven and run it with `java -jar` like a normal [Spring boot application](https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-running-your-application.html).
For the database you can run to docker containers, one for the database itself and one for [pgAdmin4](https://www.pgadmin.org/).
+ Postgresql database:
`docker run --name local-postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres`
+ pgAdmin4
`docker run --name local-pgadmin --link local-postgres -e "PGADMIN_DEFAULT_EMAIL=ronald@buit.net" -e "PGADMIN_DEFAULT_PASSWORD=postgres" -p 80:80 -d dpage/pgadmin4`
## Sonar
For collecting code quality metrics [Sonar](https://sonarcloud.io/) is used. To collect the data first the code coverage is measured by [JaCoCo](https://www.eclemma.org/jacoco/):
`mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install -Dmaven.test.failure.ignore=false`
Collecting the data:
`mvn sonar:sonar -Dsonar.projectKey=ronaldbuit_shoppinglist -Dsonar.organization=ronaldbuit-github -Dsonar.host.url=https://sonarcloud.io -Dsonar.login=SECRETKEY`
