# Ad_Campaign
This App is designed using Spring Boot. Restful webservices in Java using Annotations.

Architecture is designed as loosely coupled by separting the logic into service layer and calling from Controller Classes. 
Entities are separated and combined by Spring data using inbuilt Jparepository.
Maven is the project build tool.

Services support create get put and delete methods.

App can be tested by using command line. Please go into the project folder and type "mvn spring-boot:run".
It is compiled on jdk 1.8.
 Can be tested in POSTMAN client by running the services using the above command. and hitting localhost:8080.
 
 testcases are included in src/main/test to be run as Junit tests.
