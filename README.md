# Game Collecting Inventory

A Java command-line application for managing a video game collection, tracking consoles, and recording purchase details. The application uses MySQL to store collection data and JDBC to communicate with the database.

**Project status:** In development.

## Features

- **Game management:** Add games with a title, platform, region, condition, and boxed status.
- **Console management:** Record console models, regions, conditions, and boxed status.
- **Purchase tracking:** Store purchase prices, sellers, dates, and links to collection items through their IDs.
- **Collection browsing:** List all saved games, consoles, and purchases.
- **Item lookup:** View individual games and consoles by ID.
- **Database integration:** Persist collection data using MySQL and JDBC.

## Tech Stack

- Java
- MySQL
- JDBC
- MySQL Connector/J 9.6.0

## Project Structure

```text
Game_Collecting/
├── src/
│   └── gamecollecting/
│       ├── commands/   # Collection commands
│       ├── data/       # Database connections and data access
│       ├── main/       # Application entry point and command parser
│       └── model/      # Game, Console and Purchase models
├── lib/                # MySQL JDBC driver
├── config.example.properties
├── .gitignore
└── README.md
```

## Requirements

Before running the application, you will need:

- Java JDK
- MySQL Server
- A MySQL database configured with the required tables
- The MySQL Connector/J driver included in the Java classpath

## Setup

### 1. Clone the repository

```bash
git clone https://github.com/harleycooper2006/Game_Collecting.git
cd Game_Collecting
```

### 2. Create the database

Create the database in MySQL:

```sql
CREATE DATABASE gamevault;
```

The application expects `game`, `console`, and `purchase` tables with the columns used by the Java data-access code. A complete database schema script is not currently included in the repository, so the tables must be created separately.

### 3. Configure the database connection

Copy `config.example.properties` to a new file called `config.properties` in the project root.

Update it with your local MySQL credentials:

```properties
db.url=jdbc:mysql://localhost:3306/gamevault
db.user=YOUR_MYSQL_USERNAME
db.password=YOUR_MYSQL_PASSWORD
```

The application loads these settings when connecting to the database. Keep your personal `config.properties` file private and do not commit real credentials to GitHub.

### 4. Compile and run

From the project root, the following commands can be used in Windows PowerShell:

```powershell
javac -cp "lib/mysql-connector-j-9.6.0.jar" -d out (Get-ChildItem -Recurse src -Filter *.java | ForEach-Object { $_.FullName })
java -cp "out;lib/mysql-connector-j-9.6.0.jar" gamecollecting.main.Main
```

These commands compile the Java source files and launch the application. MySQL must be running and configured correctly for database operations to work.

## Available Commands

Type `help` after launching the application to display the supported commands.

| Command | Description |
|---|---|
| `addgame` | Add a game to the collection. |
| `addconsole` | Add a console to the collection. |
| `addpurchase` | Record a purchase. |
| `listgames` | List saved games. |
| `listconsoles` | List saved consoles. |
| `listpurchases` | List recorded purchases. |
| `showgame <id>` | View a game's details. |
| `showconsole <id>` | View a console's details. |
| `deletegame <id>` | Delete a game by ID. |
| `help` | Display available commands. |
| `exit` | Exit the application. |


This project demonstrates Java programming, object-oriented design, command parsing, and relational database integration.
