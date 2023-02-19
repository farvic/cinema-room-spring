<!-- Improved compatibility of back to top link: See: https://github.com/othneildrew/Best-README-Template/pull/73 -->
<a name="readme-top"></a>
<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Don't forget to give the project a star!
*** Thanks again! Now go create something AMAZING! :D
-->

<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
<!-- [![Contributors][contributors-shield]][contributors-url] -->
<!-- [![Forks][forks-shield]][forks-url] -->
<!-- [![Stargazers][stars-shield]][stars-url] -->
<!-- [![Issues][issues-shield]][issues-url] -->
<!-- [![MIT License][license-shield]][license-url] -->
[![LinkedIn][linkedin-shield]][linkedin-url]

<!-- PROJECT LOGO -->
<!-- <br />
<div align="center">
  <a href="https://github.com/othneildrew/Best-README-Template">

  </a>

  <h3 align="center">Best-README-Template</h3>

  <p align="center">
    An awesome README template to jumpstart your projects!
    <br />
    <a href="https://github.com/othneildrew/Best-README-Template"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/othneildrew/Best-README-Template">View Demo</a>
    ·
    <a href="https://github.com/othneildrew/Best-README-Template/issues">Report Bug</a>
    ·
    <a href="https://github.com/othneildrew/Best-README-Template/issues">Request Feature</a>
  </p>
</div> -->

# Cinema Room REST API

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->
## About The Project

The Cinema Room Rest Service is a backend project developed as a [Hyperskill](https://hyperskill.org/projects/189) challenge from the [Java Backend Developer Track](https://hyperskill.org/tracks/12). It was divided in four parts in which the developer had to implement some tasks that go through tests before going to the next part.

## Built With

* [Spring Boot 3.0.2](https://start.spring.io) and [Java 17](https://www.java.com/download/)
* [Maven 3.8.6](https://maven.apache.org/download.cgi)

## Some topics covered doing the project

* REST API
* Domain-Driven Design
* Tests with JUnit Jupiter, MockMvc and Mockito
* Databases with H2 embedded database
* Custom Exception Handling
* Logging
* Swagger UI API

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- GETTING STARTED -->

## Getting Started

1. . Clone the repo

   ```sh
   git clone https://github.com/farvic/cinema-room-spring.git
   ```

2. Run using Maven or your IDE

   ```bash
   mvn spring-boot:run
   ```

3. In order to run the tests

   ```bash
   mvn test
   ```

4. Some relevant lines from the application.properties

   ```properties
    # localhost:8080/
    port=8080


    # localhost:8080/swagger-ui/index.html

    springdoc.swagger-ui.path=/swagger-ui.html
    springdoc.api-docs.path=/v3/api-docs
    sprindoc.swagger-ui.config-url=/v3/api-docs/swagger-config
    springdoc.swagger-ui.url=/v3/api-docs


    # H2 Database name - in memory database
    spring.datasource.url=jdbc:h2:mem:testdb
    spring.h2.console.enabled=true

    # localhost:8080/h2-console
    spring.h2.console.path=/h2-console

    spring.datasource.driverClassName=org.h2.Driver

    # authentication to access the database console
    spring.datasource.username=sa
    spring.datasource.password=
   ```

5. An API documentation can be accessed through [localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html) once the program is running

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- USAGE EXAMPLES -->
## The Challenge

The project was devided in four parts. In order to avoid a very long readme, you can access the readme about each of the parts by going to the tasks' folder or clicking on one of the links below:

1. [The show begins](tasks/Part%201%20-%20The%20show%20begins/task.md)
2. [Take your seat](tasks/Part%202%20-%20Take%20your%20seat/task.md)
3. [A change of plans](tasks/Part%203%20-%20A%20change%20of%20plans/task.md)
4. [The statistics](tasks/Part%204%20-%20The%20statistics/task.md)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- ROADMAP -->
## Roadmap

* [x] Migrate the project from the [old repository](https://github.com/farvic/java-projects) to this one
* [x] Organize the folders
* [x] Update the readme with details about the project
* [ ] Add a remote database support with a Dockerfile
* [ ] And more...?

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- CONTRIBUTING -->
<!-- ## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#readme-top">back to top</a>)</p> -->

<!-- CONTACT -->
## Contact

If you want to talk about the project, feel free to contact me through one of my socials.

Victor Fonseca - [@Linkedin](https://www.linkedin.com/in/victorfa)

Project Link: [https://github.com/farvic/cinema-room-spring](https://github.com/your_username/repo_name)

<p align="right">(<a href="#readme-top">back to top</a>)</p>
