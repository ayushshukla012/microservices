# Microservices Project

This project is a Java-based microservices architecture designed to provide a scalable, modular, and efficient backend system. Each microservice handles a specific functionality and communicates using REST APIs and/or messaging queues.

## Installation

1.Prerequisites

    JDK 17+
    Maven/Gradle
    IntelliJ idea
    MySQL


## Usage

```python
1. Take clone of `https://github.com/ayushshukla012/microservices` repository.
2. Open all 4 projects in IntelliJ Idea separately.
3. Make sure Java 17 is installed and using in IDE.
4. Run each project separately.
```

## Project Explanation

1. This is a Quiz and question project.
2. In this Quiz contains names of quizzes happening.
3. The question contains the question for each quiz which is mapped with the quiz id.
4. Service Registry is used to manage the instances of the quiz and question application.
5. ApiGateway is used to so only 1 url is required for all the projects so request for quiz or question goes through the ApiGateway project.

## Contributing

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.

Please make sure to update tests as appropriate.
