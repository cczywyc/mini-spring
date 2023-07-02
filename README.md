# mini-spring
> This project is for the purpose of learning spring and communication, following the [MiniSpring course](https://time.geekbang.org/column/intro/100536701) on geektime

A mini spring framework for learning, it is written in Java.

In this project, we will not create some new concepts. The components and design concepts that appear in the project are all from the spring framework. For these components and concepts, we write simplified implementations with reference to their implementation principles.

We plan to implement IoC container, Spring MVC, JDBC Template and AOP.
- [X] IoC container
- [ ] Spring MVC
- [ ] JDBC Template
- [ ] AOP

## Ioc container
The IoC container is the core of the Spring framework. It uses this container to manage all beans and solve the coupling problem between upper-level application business objects.

## Spring MVC
Spring MVC is a module used by Spring to support web development, and it is implemented based on Servlet technology. In this project, our basic idea is to use the Servlet mechanism to intercept all requests with a single Servlet, and then assign tasks to different business classes according to the information in the request to realize the original MVC structure.

## JDBC Template
JDBC Template is Spring's implementation of data access. In this part, the entire implementation of JDBC Template uses the previous IoC management bean method to abstract data access into individual beans and inject them into the system.

## Spring AOP
AOP is an exploration of practical aspect-oriented programming in the Spring framework. In this part, we will use JDK dynamic proxy to implement Spring AOP. Specifically, we will dynamically insert business logic according to the principle of dynamic proxy implementation to realize the characteristics of aspects.

Below is the project outline from geektime
![](https://static001.geekbang.org/resource/image/b8/b0/b869b5b84170e42be1c45e5e47e453b0.jpg)
