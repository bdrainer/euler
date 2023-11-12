# Project Euler

[Project Euler](https://projecteuler.net/) solutions implemented with Groovy.

Check the archives on Project Euler as most the problems are there.

## Overview

This project uses Spring WebFlux, see [Spring Reactive](https://spring.io/reactive) 

This project is intended for fun and learning.  Learning math concepts, but also learning and using Spring WebFlux, Groovy and Gradle.  

## Development

Development of this app has been done on a Mac.

I am using [SDK Man](https://sdkman.io/) to provide the JDK and Gradle.

JDK: 21: `sdk install java 21-amzn`

Gradle: 8.4: `sdk install gradle 8.4`

## Build

To build:  `./gradlew clean build`

## Run

The application runs on port `8080` by default.

To run: `/.gradlew bootRun`

## Testing

There is a Postman collection in the project root.  It has the endpoints to test the different
problems.  

Postman isn't required, cURL or a browser is all you need.  The problems are all implemented
as GET requests in their respective REST controller.


