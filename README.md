# Maze Runner (Arduino Project)  
**Module:** Computer Architecture (Year 1 — Semester 2)
**Deadline:** Monday 22th of April 2024 @ 09.00

This project implements Arduino code for a maze-navigating robot.  
The goal of the assignment was to develop code capable of navigating a maze using *whisker sensors* to detect obstacles, and respond with appropriate lighting and audio signals.

This project branch contains my submitted version of the assignment.

---

## 🗂 Project Structure
```
maze_runner/maze_runner.ino
LICENCE    (MIT Licence)
README.md  (this file)
```

## ✅ Assessment Requirements
The robot must:

### 🔹 Maze Navigation
- Navigate through a maze with **one entry and one exit**.
- Maze-logic should be **generalized**, not hard-coded for a single layout.
- The robot must react correctly to any similar maze structure.

### 🔹 Whisker Sensors
- Use whisker inputs to detect obstacles and turns.
- When a whisker is triggered:
  - Light up an LED  
  - Emit a beep  
  - Perform a turn maneuver

### 🔹 Reversing Behaviour
- If the bot reverses:
  - Emit a **series of beeps**

### 🔹 Code Quality Requirements
- Code must be **well structured**
  - functions  
  - loops  
  - reusable logic  
- Must be **fully commented**

## ✅ My Implementation
- The project includes my Arduino `.ino` file.  
- This version of the bot **did not complete the maze** successfully, but all sensor, LED, and audio logic is implemented according to the brief.
- The structure uses functions for:
  - movement  
  - whisker detection  
  - turning  
  - reversing sequences  
  - beeping logic  

> [!NOTE]
> This branch follows my project naming convention:  
> `project/yearXX/module-<module_name>/<project-name>`  
> `project/year01/module-computer_architecture/maze-runner`

_✍️ Copy Dany_
