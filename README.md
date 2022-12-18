# holy-food-9262
<h1 align=center>Foodu</h1>
<div align=center><img  src="./Logo/Foodu.png"></div>
<h3 align=center>  Wellcome To Foodu App </h3>
# REST API for an Online Food Application

### This is a collaborative project, completed by a team of 4 Java backend developers at Masai School.

<li>We have developed this REST API for an Online Food Booking application. This API performs
  all the fundamental CRUD operations of any Online Food Booking platform with user validation at every step.</li>
<li>This project is developed by team of 4 Back-end Developers during project week in Masai School.</li>
 
<h3 align=center>  Team Members </h3>

- [Satyajit Ray](https://github.com/Satyajit0007)
- [Divya Gupta](https://github.com/Divya1327)
- [Aasim Syed](https://github.com/)
- [Piyush Kumar](https://github.com/piyushfromit)
- [Pratyay Chakraborty](https://github.com/Rahul9332935)

# Tech Stack
- Java
- Spring Framework
- Spring Boot
- Spring Data JPA
- MySQL
- Swagger UI
- Lambok
- Maven

# Modules

- Login Module
- Restaurant owner Module
- Customer Module
- Category Module
- FoodCart Module
- Order and Bill Module

# Features

- Data Authentication and Validation for all the users (Restaurnat owner, Customer)

## Owner Features
- Owner can login by giving valid credentials.
- Owner can add category and provide the item to the respective category. 
- Owner can add the status and set the price.


## Customer Features
- Customer can login in the application and update their information using their username and password.
- Customer can book food item using by adding into cart and destination.
- Customer can access the bill after the purchase & can have the history is completed.


# Installation & Run
 - Before running the API server, you should update the database config inside the application.properties file.
- Update the port number, username and password as per your local database configuration.

```
    server.port=8081

    spring.datasource.url=jdbc:mysql://localhost:3306/food;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root
```

# API Root Endpoint
```
https://localhost:8800/
```
```
http://localhost:8800/swagger-ui/
```
# API Reference
