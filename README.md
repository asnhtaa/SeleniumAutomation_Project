# SeleniumAutomation_Project

## Project Description

This project is a Selenium automation framework developed in Java that aims to thoroughly test the functionalities of a website [The-Internet](https://the-internet.herokuapp.com/). By utilizing the Selenium WebDriver and TestNG testing framework, the project provides a robust and reliable test suite to validate the behavior of the website under various scenarios.

## Technical Requirements

* Java 19
* Apache Maven for build management
* Selenium WebDriver 4.8.1 for automation
* TestNG 7.7.1 for test management
* Log4j 2.20.0 for logging
* Apache POI 5.2.3 for Excel file handling

## Project Setup Instructions

1) Install Java Development Kit (JDK) on your system. You can download the JDK from the [official Oracle website](https://www.oracle.com/). Verify your Java installation by running the following command in the terminal or command prompt:
   
```
java -version
```

2) Install Apache Maven on your system. You can download it from the [Apache Maven website](https://maven.apache.org/) and follow the installation instructions for your operating system.

3) Clone this repository to your local machine

```
git clone https://github.com/asnhtaa/SeleniumAutomation_Project.git
```

4) Open a terminal or command prompt, navigate to the project directory, and run the following command to build the project and execute the tests:

```
mvn clean test
```

5) The tests will start running on the specified web browsers (Chrome, Firefox, Edge, or Safari) based on the configuration in the project.
