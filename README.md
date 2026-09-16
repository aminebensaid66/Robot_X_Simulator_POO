# Robot X Simulator

A JavaFX robot-navigation simulator demonstrating object-oriented modeling, grid maps, obstacles, charging points, and pathfinding.

## Features

- Interactive JavaFX/FXML interface
- Basic and advanced robot models
- Obstacles and charging-point objects
- Route calculation across a simulated map
- Separation between simulation entities, pathfinding, and UI control

## Structure

```text
src/main/java/com/example/demo/
├── Controller.java
├── Map.java
├── Robot.java
├── RobotBasic.java
├── RobotAdvanced.java
├── Pathfinding.java
└── ...
```

## Run

Requirements: JDK 22 and Maven.

```bash
./mvnw clean javafx:run
```

On Windows:

```powershell
mvnw.cmd clean javafx:run
```

## Concepts demonstrated

- Inheritance and interfaces
- Encapsulation of map entities
- JavaFX controllers and FXML views
- Path representation and search
- Maven-based desktop application structure

## Status

Educational simulator. The repository contains generated IDE, binary, and build artifacts from the original development environment; the `src/` tree and root `pom.xml` are the authoritative sources.
