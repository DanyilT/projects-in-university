# Computer Architecture

This module introduces the basics of computer architecture and the principles of digital logic design. The module covers the fundamental concepts of digital systems, including binary numbers, logic gates, and Boolean algebra. The module also covers the design and implementation of combinational and sequential circuits using logic gates and flip-flops. The module includes practical activities to build and test digital circuits using breadboards and logic gates.

## Table of Contents

- [Labs](#labs)
    - [Lab 1](#lab-1-introduction): Introduction
    - [Lab 2](#lab-2-shield-resistors-and-leds): Shield, Resistors and LEDs
    - [Lab 3](#lab-3-led-servo-signal-monitors): LED Servo Signal Monitors
    - [Lab 4](#lab-4-attach-the-boe-shield-to-the-chassis): Attach the BOE Shield to the Chassis
    - [Lab 5](#lab-5-programming-strategies-for-boe-shield-bot): Programming Strategies for BOE Shield-Bot
    - [Lab 6](#lab-6-tactile-navigation-with-whiskers): Tactile Navigation with Whiskers
- [Final Project](#final-project)

## Labs

### [Lab 1](Lab1): Introduction

This lab introduces the Arduino Uno and the BOE Shield-Bot. How to set up the Arduino Development Environment, write and upload basic sketches, and understand fundamental programming concepts such as functions, variables, and loops. The lab also covers how to make the Shield-Bot perform basic maneuvers and respond to sensor inputs.

[Tasks](Lab1/Sem2-La1.pdf) | [Solutions .ino files](Lab1)

- [ex1](Lab1/ex1/ex1.ino)
- [ex2](Lab1/ex2/ex2.ino)
- [ex3](Lab1/ex3/ex3.ino)
- [ex4](Lab1/ex4/ex4.ino)
- [ex5](Lab1/ex5/ex5.ino)
- [ex6](Lab1/ex6/ex6.ino)
- [ex7](Lab1/ex7/ex7.ino)

### [Lab 2](Lab2): Shield, Resistors and LEDs

This lab focuses on using the BOE Shield to build and test circuits with resistors and LEDs. The basics of building circuits, understanding resistor color codes, and making the Arduino interact with these circuits. The lab includes activities for setting up the BOE Shield, building and testing LED indicator lights, and programming the Arduino to control the LEDs.

[Tasks](Lab2/Sem2-La2.pdf) | [Solutions .ino files](Lab2)

- [ex1](Lab2/ex1/ex1.ino)
- [ex2](Lab2/ex2/ex2.ino)
- [ex3](Lab2/ex3/ex3.ino)
- [ex4](Lab2/ex4/ex4.ino)

### [Lab 3](Lab3): LED Servo Signal Monitors

This lab covers the use of LEDs to monitor servo signals. How to generate servo control signals using the Arduino, understand the importance of precise timing for servo motor control, and use the Arduino Servo library for more accurate and efficient signal generation. The lab includes activities for setting up and testing servo signals, connecting servos to the BOE Shield, and controlling servo speed and direction.

[Tasks](Lab3/Sem2-La3.pdf) | [Solutions .ino files](Lab3)

- [ex1](Lab3/ex1/ex1.ino)
- [ex2](Lab3/ex2/ex2.ino)

### [Lab 4](Lab4): Attach the BOE Shield to the Chassis

This lab involves attaching the BOE Shield to the chassis and testing the servos to ensure proper electrical connections. How to build a start-reset indicator circuit, program the Arduino to control servo motors, and test servo speed and direction. The lab includes activities for assembling the BOE Shield-Bot, connecting the battery pack, and using a piezospeaker to play some sounds.

[Tasks](Lab4/Sem2-La4.pdf) | [Solutions .ino files](Lab4)

- [ex1](Lab4/ex1/ex1.ino)
- [ex2](Lab4/ex2/ex2.ino)
- [ex3](Lab4/ex3/ex3.ino)

### [Lab 5](Lab5): Programming Strategies for BOE Shield-Bot

This lab introduces different programming strategies to make the BOE Shield-Bot move. How to control the BOE Shield-Bot's movements, including moving forward, backward, rotating, and pivoting. The lab also covers creating functions for each maneuver to simplify navigation and improve code reusability.

[Tasks](Lab5/Sem2-La5.pdf) | [Solutions .ino files](Lab5)

- [ex1](Lab5/ex1/ex1.ino)
- [ex2](Lab5/ex2/ex2.ino)
- [ex3](Lab5/ex3/ex3.ino)
- [ex4](Lab5/ex4/ex4.ino)
- [ex5](Lab5/ex5/ex5.ino)

### [Lab 6](Lab6): Tactile Navigation with Whiskers

This lab introduces tactile navigation using whisker switches. Build and test whisker circuits, program the BOE Shield-Bot to monitor whisker states, and implement autonomous navigation by touch. The lab includes activities for building whisker circuits, testing whisker inputs, and programming the BOE Shield-Bot to respond to obstacles using whisker inputs.

[Tasks](Lab6/Sem2-La6.pdf) | [Solutions .ino files](Lab6)

- [ex1](Lab6/ex1/ex1.ino)
- [ex2](Lab6/ex2/ex2.ino)
- [ex3](Lab6/ex3/ex3.ino)

## Final Project

This is have to be the final project for the module.

### [Maze_Runner](Final%20Project)

This is a code for Arduino Uno Vechile to navigate through a maze. The vehicle is equipped with a servo motor and whisker switches to detect obstacles and navigate around them. The code uses a combination of servo control, whisker input monitoring, and decision-making logic to guide the vehicle through the maze autonomously.

[Tasks](FinalProject/FinalProject.pdf) | [Solutions](FinalProject/Maze_Runner/Maze_Runner.ino)
