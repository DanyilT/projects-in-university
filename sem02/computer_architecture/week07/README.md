# Week 07 — Lab 5: programming strategies for the Shield-Bot

**Module:** Computer Architecture (`COMP H1027`)  
**Semester:** 2 (Year 1), folder `sem02`

[Module README](../README.md)

## What this week is for

Lab 5 is about making the Shield-Bot move: forward, backward, turning on the spot and pivoting on one wheel, with a function for each manoeuvre. The MCQ test is in week 11, not in this week. The sketches: ex1 runs a short sequence of moves, ex2 drives forward for ten seconds, ex3 plays two tones, ex4 repeats the moves in a loop, and ex5 puts all the manoeuvres into one function.

> [!CAUTION]
> - [`lab/solution/ex3/ex3.ino`](lab/solution/ex3/ex3.ino): It does not compile as stored: the function uses ms, which is never declared.
> - [`lab/solution/ex5/ex5.ino`](lab/solution/ex5/ex5.ino): The last call passes -1 as the time, and delay(-1) waits a very long time because the argument is unsigned.

## Files

| File | What it contains | Screenshot |
|---|---|---|
| [`README.md`](README.md) | This README. | — |
| [`lab/computer_architecture_week07_lab.pdf`](lab/computer_architecture_week07_lab.pdf) | The lab sheet (15 pages): moving the Shield-Bot forward, turning, pivoting, and writing a function for each manoeuvre. | — |
| [`lab/solution/ex1/ex1.ino`](lab/solution/ex1/ex1.ino) | Plays a tone, then drives forward for two seconds, turns each way for 0.6 s, reverses for two seconds, and sets four pivot steps with no delay between them. It then detaches the servos. | <img src="../.screenshots/week07/screenshot_1.png" alt="Week 07 screenshot 1" width="400"><br>*Arduino IDE showing ex1.ino.* |
| [`lab/solution/ex2/ex2.ino`](lab/solution/ex2/ex2.ino) | Plays a tone, drives forward for ten seconds, then detaches the servos. | <img src="../.screenshots/week07/screenshot_2.png" alt="Week 07 screenshot 2" width="400"><br>*Arduino IDE showing ex2.ino.* |
| [`lab/solution/ex3/ex3.ino`](lab/solution/ex3/ex3.ino) | Plays two tones through a pitch(Hz) function. | <img src="../.screenshots/week07/screenshot_3.png" alt="Week 07 screenshot 3" width="400"><br>*Arduino IDE showing ex3.ino.* |
| [`lab/solution/ex4/ex4.ino`](lab/solution/ex4/ex4.ino) | Repeats forward (two seconds), turn left, turn right and backward in a loop, with one function per manoeuvre. | <img src="../.screenshots/week07/screenshot_4.png" alt="Week 07 screenshot 4" width="400"><br>*Arduino IDE showing ex4.ino.* |
| [`lab/solution/ex5/ex5.ino`](lab/solution/ex5/ex5.ino) | The same manoeuvres as ex4, through one maneuver(speedLeft, speedRight, time) function. | <img src="../.screenshots/week07/screenshot_5.png" alt="Week 07 screenshot 5" width="400"><br>*Arduino IDE showing ex5.ino.* |
