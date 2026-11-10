# Week 05 — Lab 3: LED servo signal monitors

**Module:** Computer Architecture (`COMP H1027`)  
**Semester:** 2 (Year 1), folder `sem02`

[Module README](../README.md)

## What this week is for

Lab 3 covers servo control signals: the timing of the pulses, the Servo library, and how the pulse width sets a servo's speed and direction. ex1 sends the 1.5 ms stay-still pulse to two servos. ex2 turns the two wheels in opposite directions for three seconds each.

## Files

| File | What it contains | Screenshot |
|---|---|---|
| [`README.md`](README.md) | This README. | — |
| [`lab/computer_architecture_week05_lab.pdf`](lab/computer_architecture_week05_lab.pdf) | The lab sheet (22 pages): servo timing, with the ServoSlowMo example sketches. | — |
| [`lab/solution/ex1/ex1.ino`](lab/solution/ex1/ex1.ino) | Attaches two servos to pins 13 and 12 and sends both of them the 1.5 ms stay-still signal (1500 microseconds). | <img src="../.screenshots/week05/screenshot_1.png" alt="Week 05 screenshot 1" width="400"><br>*Arduino IDE showing ex1.ino.* |
| [`lab/solution/ex2/ex2.ino`](lab/solution/ex2/ex2.ino) | Runs both servos clockwise for three seconds, counterclockwise for three seconds, then stops them. | <img src="../.screenshots/week05/screenshot_2.png" alt="Week 05 screenshot 2" width="400"><br>*Arduino IDE showing ex2.ino.* |
