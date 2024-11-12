# Fundamentals of Programming 1

> This module introduces the fundamental concepts of programming using Java. The module covers basic syntax, control structures, data types, etc. The module is assessed through a series of lab exercises. Each lab exercise is designed to enhance understanding of various programming concepts and their applications in solving computational problems.

## Table of Contents

- [Labs](#labs)
    - [Lab 0](#lab-0-exercise-sheet-0): Exercise sheet 0
    - [Lab 1](#lab-1-exercise-sheet-1): Exercise sheet 1
    - [Lab 2](#lab-2-exercise-sheet-2): Exercise sheet 2
    - [Lab 3](#lab-3-exercise-sheet-3): Exercise sheet 3
    - [Lab 4](#lab-4-exercise-sheet-4): Exercise sheet 4
    - [Lab 5](#lab-5-exercise-sheet-5): Exercise sheet 5
    - [Lab 6](#lab-6-exercise-sheet-6): Exercise sheet 6
    - [Lab 7](#lab-7-exercise-sheet-7): Exercise sheet 7
    - [Lab 8](#lab-8-exercise-sheet-8): Exercise sheet 8
    - [Lab 9](#lab-9-exercise-sheet-9): Exercise sheet 9
    - [Lab 10](#lab-10-exercise-sheet-10): Exercise sheet 10

## Labs

### [Lab 0](Lab0) Exercise sheet 0

This lab introduces the basics of Java programming, including setting up the development environment, writing simple programs, and understanding the compilation and execution process.

[Tasks](Lab1/Sem1-Lab0.pdf) | [Solutions .java files)](Lab0)

#### Questions

1. Open a new text file in the TextPad editor and type in the following Java code. Save the file as `HelloWorld.java`. Compile and run your HelloWorld program using the command line `javac` and `java` commands. Program named as [`HelloWorld.java`](Lab0/HelloWorld.java).
        ```java
        public class HelloWorld {
            public static void main(String[] args) {
                System.out.println("Hello World!");
            }
        }
        ```

2. Write a new Java program called `MyName.java` that prints your name to the screen. Compile and run this program from the command line using the `javac` and `java` commands. Program named as [`MyName.java`](Lab0/MyName.java).

3. Write a Java program called `NewHope.java` that prints the following text to the screen. Compile and run this program from the command line using the `javac` and `java` commands. Program named as [`NewHope.java`](Lab0/NewHope.java).
        ```
        Episode IV, A NEW HOPE
        It is a period of civil war. Rebel spaceships, striking from a hidden base, have won their first victory against the evil Galactic Empire. During the battle, Rebel spies managed to steal secret plans to the Empire’s ultimate weapon, the DEATH STAR, an armoured space station with enough power to destroy an entire planet.
        ```

4. Download the `Broken.java` source file from nowhere. Compile the program on the command line using the `javac` command. Open the `Broken.java` file in TextPad and try to fix the errors it contains, compile the code with `javac` to check for errors. When you have fixed all the errors in `Broken.java`, run the program using the `java` command. Program named as [`Broken.java`](Lab0/Broken.java).

### [Lab 1](Lab1) Exercise sheet 1

This lab focuses on basic Java programming concepts, including variables, data types, arithmetic operations, and input/output operations.

[Tasks](Lab1/Sem1-Lab1.pdf) | [Solutions (.java files)](Lab1)

#### Questions

1. Write a Java program that produces the following output. Program named as [`Question1.java`](Lab1/Question1.java).
    ```
    Java Programming
    Rocks
    ```

2. Write a Java program that prints the answers to the following arithmetic expressions on **separate** lines. Program named as [`Question2.java`](Lab1/Question2.java).
    ```
    1. 4 x 4 = result
    2. 3 x 7 + (-2 x -8) = result
    3. (" × %)'( () × *)'+, = result
    ```

3. Write a Java program that uses two variables **x** and **y** to store the values **71** and **3.14**. Your program should print the values stored in **x** and **y** to the screen. Program named as [`Question3.java`](Lab1/Question3.java).
    ```
    x = 71
    y = 3.14
    ```

4. An employee receives an hourly rate of €9.80 and works 42 hours a week. Write a Java program that calculates the employee's gross weekly wage and prints it to the screen. Program named as [`Question4.java`](Lab1/Question4.java).
    ```
    Hourly rate is 9.8
    Hours worked is 42
    Gross weekly is 411.6
    ```

5. Given the following function `f(x) = x² + 3x - 5`, write a Java program to evaluate **f(x), where x = 4**. Your program should use a variable called x and print the linear arithmetic expression along with the result. Program named as [`Question5.java`](Lab1/Question5.java).
    ```
    x² can be written as (x * x)
    ```

### [Lab 2](Lab2) Exercise sheet 2

This lab focuses on more advanced Java programming concepts, including loops, conditionals, and methods.

[Tasks](Lab2/Sem1-Lab2.pdf) | [Solutions (.java files)](Lab2)

#### Questions

1. Write a Java program that prints the **quotient** and **remainder** on dividing the constant **X** by the constant **Y**. The constant **X** should be initialized to **5** and the constant **Y** should be initialized to **3**. Your program should use two variables called **quotient** and **remainder** to store results and you should use a single `System.out.println` statement to print the result in the format below. Program named as [`Question1.java`](Lab2/Question1.java).
    ```
    X / Y = 1 and X % Y = 2
    ```

2. Write a Java program to calculate an employee’s gross weekly pay. The **input** to the program should be the **number of hours worked** and the **hourly rate of pay**. Your program output should look as follows and you should **test your program using the values shown below**. Program named as [`Question2.java`](Lab2/Question2.java).
    ```
    Please input hourly rate: 9.6
    Please input hours worked: 45
    Hours worked = 45.0 hourly rate = 9.6 gross weekly = 432.0
    ```

3. Write a program that **prompts** the user for **four integer values** (use four separate variables) and prints their average. Your program output should look as follows and you should use the test values shown below. Program named as [`Question3.java`](Lab2/Question3.java).
    ```
    Enter number 1: 1
    Enter number 2: 2
    Enter number 3: 3
    Enter number 4: 4
    Answer = 2.5
    ```

4. Write a Java program that calculates the volume of a cylinder. Your program should **prompt** the user to enter the **radius** and **height** of the cylinder and should use a combination of **constants** and **variables** to calculate the volume. The following formula should be used to calculate the volume, where V=volume, r=radius and h=height. Program named as [`Question4.java`](Lab2/Question4.java).
    ```
    V = π * r² * h
    ```
    ```
    Enter the radius: 2.5
    Enter the height: 11.5
    Volume = 225.6875
    ```

### [Lab 3](Lab3) Exercise sheet 3

This lab focuses on evaluating expressions, declaring variables, and using conditional statements.

[Tasks](Lab3/Sem1-Lab3.pdf) | [Solutions (.java files)](Lab3)

#### Questions

1. Write a single Java program that evaluates the **truth** or **falsity** of the following expressions using `System.out.println` statements as shown in the program output below. Program named as [`Question1.java`](Lab3/Question1.java).
    ```
    i. 5 – 1 != 3
    ii. 100 % 50 == 0
    iii. (21 + 7) / 4 >= 100
    ```
    ```
    5 - 1 != 3 is true
    100 % 50 == 0 is true
    (21 + 7) / 4 >= 100 is false
    ```

2. Write a single Java program that declares two integer variables called x and y. Assign x = 4, y = 10 and write Boolean expressions that represent the statements below. Your program should output the results as shown below. Program named as [`Question2.java`](Lab3/Question2.java).
    ```
    a) x is an even number
    b) x multiplied by 5 is less than 7 squared
    c) y minus x is positive
    d) y cubed is less than 100
    ```
    ```
    x is an even number is true
    x multiplied by 5 is less than 7 squared is true
    y minus x is positive is true
    y cubed is less than 100 is false
    ```

3. Write a program to read a student’s grade out of 100 from the keyboard. The program should print one of **PASS** or **FAIL**. A pass is any grade of 40% or higher. Program named as [`Question3.java`](Lab3/Question3.java).
    ```
    Enter grade: 21
    FAILED
    ```

4. Write a program to read a month number and print its month name. For example, an input of 10 would result in an output of October. Program named as [`Question4.java`](Lab3/Question4.java).
    ```
    Enter month number: 10
    October
    ```

### [Lab 4](Lab4) Exercise sheet 4

This lab focuses on evaluating expressions, using conditionals, and reading input from the keyboard.

[Tasks](Lab4/Sem1-Lab4.pdf) | [Solutions (.java files)](Lab4)

#### Questions

1. Write a Java program that evaluates and prints the **truth** or **falsity** of the following expressions; **you should assign the outcome of each expression to a Boolean variable**. Program named as [`Question1.java`](Lab4/Question1.java).
    ```
    i. 2 * 3 == 6 && 4 < 5
    ii. 3 > 1 || 5 < 3
    iii. 1 < 10 && 2 < 10 && 3 < 10
    iv. !(3 > 10) && 5 != 4
    v. (10 >= 10) && (11 >= 10)
    ```

2. Write a program that uses the Scanner to **read an integer** from the keyboard and print one of **positive**, **negative**, or **zero**. Your program should use an **if**, **else if**, and an **else**. Program named as [`Question2.java`](Lab4/Question2.java).
    ```
    Please enter an integer number: 100
    positive
    ```

3. Write a program that uses the Scanner to read in a student’s grade (0 – 100) and prints the associated alphabetic grade. Use the table below in your answer and use the test cases below. Program named as [`Question3.java`](Lab4/Question3.java).
    ```
    | GRADE | PERCENTAGE BAND |
    |-------|-----------------|
    | A     | 80-100          |
    | B+    | 70-79           |
    | B     | 60-69           |
    | B-    | 55-59           |
    | C+    | 50-54           |
    | C     | 40-49           |
    | D     | 35-39           |
    | F     | 0-34            |
    ```
    ```
    Please enter your grade (0-100): 81
    A
    ```

4. Write a program that uses the Scanner to read the lengths of three sides of a triangle (**A**, **B**, and **C**) and prints one of **TRIANGLE** or **NOT A TRIANGLE**. Program named as [`Question4.java`](Lab4/Question4.java).
    ```
    Triangle Inequality Theorem: The sum of the two sides must be greater than the longest side.
    C is the longest side so (6 + 5 > 10) == true
    C is the longest side but (5 + 5 > 10) == false
    ```
    ```
    Enter length of line A: 6
    Enter length of line B: 5
    Enter length of line C: 10
    TRIANGLE
    ```

### [Lab 5](Lab5) Exercise sheet 5

This lab focuses on reading input values, validating ranges, and determining triangle properties.

[Tasks](Lab5/Sem1-Lab5.pdf) | [Solutions (.java files)](Lab5)

#### Questions

1. Write a program to read an integer value in the range 1..100 and output its value in words. For example, if the input is **45** then the output is **“forty five”**. If the number entered is not within the valid range the program should print “Invalid number!”. Use the test cases shown below. Program named as [`Question1.java`](Lab5/Question1.java).
    ```
    Please enter a number between 1 - 100: 1
    One
    ```

2. Write a program that reads the length of any three lines a, b, c and prints one of:
    ```
    A) Triangle; followed by either scalene, isosceles or equilateral; followed by either right-angled or not right-angled,
    B) Not a triangle.
    ```
    ```
    Enter length of line A: 3
    Enter length of line B: 2
    Enter length of line C: 5
    Not a triangle
    ```

### [Lab 6](Lab6) Exercise sheet 6

This lab focuses on using loops, generating random numbers, and calculating compound interest.

[Tasks](Lab6/Sem1-Lab6.pdf) | [Solutions (.java files)](Lab6)

#### Questions

1. Write a Java program that contains **two separate** for-loops. The first loop should print the numbers from 1 to 50 and the second loop should print the numbers from 50 to 1. Your output should look similar to shown below. Program named as [`Question1.java`](Lab6/Question1.java).
    ```
    Numbers from 1 to 50
    1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50
    Numbers from 50 to 1
    50 49 48 47 46 45 44 43 42 41 40 39 38 37 36 35 34 33 32 31 30 29 28 27 26 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1
    ```

2. Write a Java program to generate and print **6 rolls** of an **eight-sided** dice. Use a **for-loop**, printf statements, and the `Math.random()` function in your answer. Your program output should be similar to the following. Program named as [`Question2.java`](Lab6/Question2.java).
    ```
    Roll: 1 You got a 5
    Roll: 2 You got a 4
    Roll: 3 You got a 8
    Roll: 4 You got a 6
    Roll: 5 You got a 8
    Roll: 6 You got a 3
    ```

3. A sum of money is invested for 6 years at 12.5% compound interest (interest is calculated based on the initial sum plus any previous interest earned). Write a program that will print out the following for each year:
    - interest for the year
    - cumulative interest (interest earned so far)
    - new capital amount
    - Program use a **for-loop** and a **printf** statement to **round** any output to **2 decimal places**. Program named as [`Question3.java`](Lab6/Question3.java).
        ```
        Enter capital to invest: 120
        YEAR 1
        Interest = 15.00, Cumulative Interest = 15.00, New Capital = 135.00
        YEAR 2
        Interest = 16.88, Cumulative Interest = 31.88, New Capital = 151.88
        YEAR 3
        Interest = 18.98, Cumulative Interest = 50.86, New Capital = 170.86
        YEAR 4
        Interest = 21.36, Cumulative Interest = 72.22, New Capital = 192.22
        YEAR 5
        Interest = 24.03, Cumulative Interest = 96.24, New Capital = 216.24
        YEAR 6
        Interest = 27.03, Cumulative Interest = 123.27, New Capital = 243.27
        ```

### [Lab 7](Lab7) Exercise sheet 7

This lab focuses on using loops, reading input, and performing calculations.

[Tasks](Lab7/Sem1-Lab7.pdf) | [Solutions (.java files)](Lab7)

#### Questions

1. Write a Java program that uses a **while loop** to prompt the user to enter **4 integer numbers**. Your program should print the product of the numbers entered when the loop ends. Use the test case shown below. Program named as [`Question1.java`](Lab7/Question1.java).
    ```
    Product of four numbers
    Enter number: 2
    Enter number: 4
    Enter number: 6
    Enter number: 8
    Product of numbers: 384
    ```

2. Write a Java program that uses a **for loop** to complete the first N rows of the following output. The number of rows **N** should be read from the keyboard. Use the test case shown below. Program named as [`Question2.java`](Lab7/Question2.java).
    ```
    1
    2 4
    3 6 9
    4 8 12 16
    ```
    ```
    Enter number of rows N: 6
    1
    2 4
    3 6 9
    4 8 12 16
    5 10 15 20 25
    6 12 18 24 30 36
    ```

3. Write a Java program that continues to read in integer numbers until the user enters the value **-1 (sentinel)**. Your program should **sum** all the **even** values entered and print the result when the loop ends. Use the following program outline as a guide. Program named as [`Question3.java`](Lab7/Question3.java).
    ```
    // prompt user to enter list of numbers with a sentinel of -1
    // read in a number
    // while the number entered is not -1
    //      if the number is even add it to the sum
    //      read in the next number
    // end of loop
    // print the sum of even number
    ```
    ```
    Enter a list of numbers, sentinel -1: 1 2 3 4 5 6 7 8 9 10 -1
    Sum equals 30
    ```

### [Lab 8](Lab8) Exercise sheet 8

This lab focuses on using arrays, loops, and performing calculations on array elements.

[Tasks](Lab8/Sem1-Lab8.pdf) | [Solutions (.java files)](Lab8)

#### Questions

1. Write a Java program that declares the array shown below. Your Java program should then print the array using **5 separate `System.out.printf` statements**. Program named as [`Question1.java`](Lab8/Question1.java).
    ```java
    int numbers[] = new int[5];
    numbers[0] = 20;
    numbers[1] = 30;
    numbers[2] = 40;
    numbers[3] = 50;
    numbers[4] = 60;
    ```
    ```
    numbers[0] = 20
    numbers[1] = 30
    numbers[2] = 40
    numbers[3] = 50
    numbers[4] = 60
    ```

2. Use the data list given below to declare and initialize an integer array. Then write **individual for loops** to solve each of the following. Program named as [`Question2.java`](Lab8/Question2.java).
    ```
    Data list: {2, 4, 6, 9, 5, 4, 5, 7, 12, 15, 21, 32, 45, 5, 6, 7, 12}
    i. Compute and print the mean (average) of all elements.
    ii. Print all elements that are greater than the mean.
    ```
    ```
    i) The mean of elements is 11.59
    ii) Value greater than 11.59
    12 15 21 32 45 12
    ```

3. Write a program that reads 5 integer values from the keyboard and prints them in reverse order. You should use an **array** and **2 separate for loops** to solve this problem. Program named as [`Question3.java`](Lab8/Question3.java).
    ```
    Enter 5 integer values: 1 2 3 4 5
    Numbers in reverse are: 5 4 3 2 1
    ```

4. Write a program that declares an integer array of size 100. Write for loops to carry out the following operations. Program named as [`Question4.java`](Lab8/Question4.java).
    ```
    i. Initialize the array with random values between 1 – 20
    ii. Print all values in the array
    ```
    ```
    Array values are:
    l0 20 2 11 2 3 10 5 99 2 2 15 1 6 1 20 18 1 11 99 4 15 20 3 15 8 10 2 20 19 5 11 l0 19 5 8 5 16 10 20 20 3 19 1 3 8 13 4 11 19 19 5 18 14 15 6 4 16 3 16 20 20 99 317 215 9 13 14 6 18 3 1 5 11 6 3 9 15 59 4 11 2 5 15 18 15 14 18 13 69 8 20 8
    ```

### [Lab 9](Lab9) Exercise sheet 9

This lab focuses on using loops, strings, and character operations.

[Tasks](Lab9/Sem1-Lab9.pdf) | [Solutions (.java files)](Lab9)

#### Questions

1. Write a program that uses a loop to print **row 6** of the ASCII table. Your output should look as follows. Program named as [`Question1.java`](Lab9/Question1.java).
    ```
    < = > ? @ A B C D E
    ```

2. Write a program that **reads in** two Strings **s1**, **s2** and prints them in alphabetical order. Program named as [`Question2.java`](Lab9/Question2.java).
    ```
    Please enter string 1: Zabba
    Please enter string 2: Abba
    Abba Zabba
    ```

3. Write a program that uses the following String variables to carry out the following. Program named as [`Question3.java`](Lab9/Question3.java).
    ```
    1. Create and print out a String called **s4** that is the **concatenation** of s1, s2 and s3
    2. Replace all occurrences of the letter **‘a’** in **s4** with ‘#’
    3. Print out all indices of the letter **‘e’** in **s4**
    ```
    ```java
    String s1 = "Always break ";
    String s2 = "the problem ";
    String s3 = "down";
    ```
    ```
    s4 = Always break the problem down
    s4 after replace = Alw#ys bre#k the problem down
    e at index 9
    e at index 15
    e at index 22
    ```

4. Write a program that generates 100 **lowercase** characters and computes the frequency of **vowel** letters ‘a’, ‘e’, ‘i’, ‘o’, ‘u’. Program named as [`Question4.java`](Lab9/Question4.java).
    ```
    n b y o d g b g n i j i m s b a s a y c k u y l c h f v u g h i f m t x a n c r u t j t h t h c w k b v d a o l o b y d t o z k n c p f p a k w f v y p b e f w o o y o c g f r n i s v q q y p c z f c h
    Frequency of vowels is: 20

### [Lab 10](Lab10) Exercise sheet 10

This lab focuses on using procedures, command line arguments, and functions.

[Tasks](Lab10/Sem1-Lab10.pdf) | [Solutions (.java files)](Lab10)

#### Questions

1. Write a Java program that declares a **procedure** called **menu** which prints the following message to the screen. Program named as [`Question1.java`](Lab10/Question1.java).
    ```
    ***************************
    *     A M O N G   U S     *
    ***************************
    *     1) Take out trash   *
    *     2) Fix wiring       *
    *     3) Card swipe       *
    *     4) Vent             *
    ***************************
    ```

2. Write a Java program that declares a **procedure** called **printAscii** that displays the printable characters on the ASCII table to the screen. Program named as [`Question2.java`](Lab10/Question2.java).
    ```
    ! " # $ % & ' ( ) * + , - . / 0 1 2 3 4 5 6 7 8 9 : ; < = > ? @ A B C D E F G H I J K L M N O P Q R S T U V W X Y Z [ \ ] ^ _ ` a b c d e f g h i j k l m n o p q r s t u v w x y z { | } ~
    ```

3. Write a Java program that converts its command line arguments to uppercase and prints them to the screen. Program named as [`Question3.java`](Lab10/Question3.java).
    ```
    ~ % java Question3 java programming rocks
    JAVA
    PROGRAMMING
    ROCKS
    ```

4. Write a Java program that prompts the user to enter the radius of a circle. Your program should calculate the Circumference and Area of the circle using the formulae shown below. Program named as [`Question4.java`](Lab10/Question4.java).
    ```
    C = 2πr
    A = πr²
    ```
    ```
    Enter circle radius: 10
    Circumference: 62.80
    Area: 314.00
    ```
