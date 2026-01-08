# RestaurantHu

Restaurant Management System - A Java Maven project for managing restaurant operations.

## Project Structure

```
RestaurantHu/
├── pom.xml
├── README.md
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── restauranthu/
│   │   │           ├── App.java
│   │   │           └── RestaurantManager.java
│   │   └── resources/
│   │       └── logback.xml
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── restauranthu/
│       │           ├── AppTest.java
│       │           └── RestaurantManagerTest.java
│       └── resources/
└── logs/ (created at runtime)
```

## Technologies Used

- **Java 11**
- **Maven 3.x**
- **JUnit 5** - For unit testing
- **SLF4J + Logback** - For logging
- **Jackson** - For JSON processing

## Getting Started

### Prerequisites

- Java JDK 11 or higher
- Maven 3.6+ 
- Your favorite IDE (IntelliJ IDEA, Eclipse, VS Code, etc.)

### Building the Project

```bash
# Navigate to project directory
cd RestaurantHu

# Clean and compile
mvn clean compile

# Run tests
mvn test

# Create JAR file
mvn package

# Run the application
java -jar target/RestaurantHu-1.0.0.jar
```

### Running from IDE

1. Import the project as a Maven project
2. Run the `App.java` main method
3. Run tests using your IDE's test runner

## Features

- Basic restaurant management system setup
- Logging configuration with file and console output
- Unit tests with JUnit 5
- Maven build automation
- JSON processing capabilities

## Development

### Adding New Features

1. Create new classes in `src/main/java/com/restauranthu/`
2. Add corresponding test classes in `src/test/java/com/restauranthu/`
3. Update dependencies in `pom.xml` if needed
4. Run `mvn test` to ensure all tests pass

### Logging

The application uses SLF4J with Logback for logging:
- Console output for immediate feedback
- File logging to `logs/restauranthu.log`
- Configurable log levels in `logback.xml`

## License

This project is created for educational/demo purposes.
