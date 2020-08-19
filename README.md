# Employee-REST API Servlet

This servlet is for Demo REST API.  It is a simple CRUD and includes the following components:
- JPA (Javax Persistance Api) Repositories handler.
 - Database Employee Entity Models.
 - Employee SQL Schema for Flyway Migration (database auto-update) framework.
 - SQL Scripts Unit tests for Spring Boot Test framework.
 - Employee REST API Controller Unit Tests.
 - Google cloud or localhost deploy environment setting script (deploy.bash).
 - Application properties setup for Google cloud and localhost.
 - Google App Engine (app.yaml) setup script.
 - Gradle build and setup scripts for Google cloud and localhost.
 
## How to run?  
  
First create the **employee_db** schema in you local database.  
  
```sql  
  CREATE SCHEMA `employee_db`  
```  
  
Next, clone this repository.  
  
```  
$ git clone https://github.com/oslynn/SimpleGrudEmployeeDemo.git <Enter>
$ cd SimpleGrudEmployeeDemo <Enter>
```

###Setup the deployment environment

To deploy in **localhost** environment:
```
$ (Optional) bash deploy.bash localhost <Enter>
$ ./gradlew build <Enter>
```
(Optional) To deploy in **google cloud** environment:
```

$ bash deploy.bash cloud <Enter>
$ ./gradlew build <Enter>
```

Finally deploy the EventliveRestApplication as Java application.

```java
$ ./gradlew bootRun <Enter>  		- deploy to localhost environment
$ ./gradlew oppengineDeploy <Enter>     - deploy to google cloud environment
```

## Documentation
### Swagger 2 or OpenApi
To allow realtime API endpoints checking, it uses the Springfox library to render the documentation of the API Swagger 2.  Therefor, developer can tryout each endpoint functionality by providing input objedt, execute the method, and see the result.

When the application is running, type the following URL in a browser:

localhost:  http://localhost:8080/employee/api/swagger-ui.html

The swagger page should appear.

--- Enjoy to play with the endpoints ---:

