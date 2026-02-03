# 🤖 RoboRally - Group 11  
*A Java Desktop Implementation of the RoboRally Board Game with BDD and MVC*

## 🚀 Overview

This is a Java-based desktop application of the classic **RoboRally** board game, developed as part of the *02160 - Agile Object-Oriented Software Development* course. The project emphasizes clean architecture, object-oriented principles, and agile development methodologies. It uses **Behavior-Driven Development (BDD)** via **Cucumber**, follows the **Model-View-Controller (MVC)** architecture, and applies design patterns like Singleton, Factory, and Observer.

> 🧪 **To start the game**, you must **run the tests inside the `cucumber-test` folder**, which launches the application via step definitions.

---

## 🎮 Game Features

### ✅ Core Functionality
- 🧠 Robot’s independent programmed movement via card selection  
- ⚙️ Robot-Tile interactions (Obstacles, Conveyor Belts, Pits, etc.)  
- 👥 Multiplayer support (2 players, extendable)  
- 🎨 Intuitive Swing-based GUI for card and round control  

### ✨ Optional Enhancements
- 🍺 **Beer Tile** – Shuffles player's hand mid-round  
- 🌀 **Teleport Tile** – Warps robot to a designated location  
- 📦 **Conveyor Belt** – Moves robot in a fixed direction  
- ⚠️ **Pit Tile** – Removes a life and respawns the robot  

---

## 🧱 Architecture

- **Model:** Core game logic (cards, tiles, board, player state)  
- **View:** GUI implementation using Java Swing  
- **Controller:** Handles game flow and event interactions  

### 🧩 Design Patterns
- 🧱 **Abstract Classes** (Cards, Tiles, Board)  
- 🔁 **Singleton** (Deck creation)  
- 🏭 **Factory Pattern** (Tile generation)  
- 🔔 **Observer Pattern** (Event-driven UI updates)  
- 📌 **Static Variables** (Global player/board state)  

💡 **SOLID Principles** were applied to ensure modularity, testability, and low coupling.

---

## 🧪 Behavior-Driven Development

The project uses [Cucumber](https://cucumber.io/) for defining user stories and acceptance criteria.

📁 **To launch the game:**

```bash
# Navigate into cucumber-test directory and run:
mvn test
