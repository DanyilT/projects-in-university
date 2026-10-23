# Week 06 — Lab 4: attach the BOE Shield to the chassis

**Module:** Computer Architecture (`COMP H1027`)  
**Semester:** 2 (Year 1), folder `sem02`

[Module README](../README.md)

## What this week is for

Lab 4 attaches the BOE Shield to the chassis, re-tests the servos and builds a start-reset indicator with a piezospeaker. The three sketches beep at start-up (ex1), step the left servo's speed (ex2) and play a melody (ex3).

## Files

| File | What it contains | Screenshot |
|---|---|---|
| [`README.md`](README.md) | This README. | — |
| [`lab/computer_architecture_week06_lab.pdf`](lab/computer_architecture_week06_lab.pdf) | The lab sheet (13 pages): attaching the shield to the chassis and re-testing the servos. | — |
| [`lab/solution/ex1/ex1.ino`](lab/solution/ex1/ex1.ino) | Plays two one-second tones on pin 4 with a Beep! message, then prints Waiting for reset... every second. | <img src="../.screenshots/week06/screenshot_1.png" alt="Week 06 screenshot 1" width="400"><br>*Arduino IDE showing ex1.ino (beep and reset message).* |
| [`lab/solution/ex2/ex2.ino`](lab/solution/ex2/ex2.ino) | Steps the left servo's pulse width from 1300 to 1700 microseconds in steps of 20. Each step waits for a key press, runs for six seconds, then stops. | <img src="../.screenshots/week06/screenshot_2.png" alt="Week 06 screenshot 2" width="400"><br>*Arduino IDE showing ex2.ino (pulse width loop).* |
| [`lab/solution/ex3/ex3.ino`](lab/solution/ex3/ex3.ino) | Plays a 13-note melody on pin 4, using the note values in pitches.h. | <img src="../.screenshots/week06/screenshot_3.png" alt="Week 06 screenshot 3" width="400"><br>*Arduino IDE showing ex3.ino and pitches.h (melody).* |
| [`lab/solution/ex3/pitches.h`](lab/solution/ex3/pitches.h) | The note frequency constants (NOTE_B0 onwards) used by the melody sketch. | — |
