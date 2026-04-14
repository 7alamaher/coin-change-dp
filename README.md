# Coin Change Problem — Minimum Coins Finder

**Name:** [Hala Elbayoumi]  
**Email:** [halaelbayoumi@oakland.edu]  
**Course:** CSI 3610 – Design and Analysis of Algorithms  
**Project Title:** Coin Change Problem using Dynamic Programming

---

## What is This Project?

Given a list of coin denominations and a target amount,
this program finds:
- The **minimum number of coins** needed to reach the target
- **Which exact coins** were used to reach that minimum

For example: with coins [1, 3, 4] and target 6,
the answer is 2 coins → 3 + 3.

---

## How Does the Algorithm Work?

This program uses **Dynamic Programming (DP).**

Instead of trying every possible combination of coins,
DP builds the answer step by step:

1. Create a table with one box for every amount from 0 to target
2. Box 0 always costs 0 coins (base case)
3. For every other box, try every coin available
4. If the coin fits, look back at the box we came from
5. If that gives a better answer, update the box
6. At the end, trace back through the table to find which coins were used

This approach guarantees the minimum number of coins
without missing any combination.

---

## Why Dynamic Programming?

The simpler "Greedy" approach (always pick the biggest coin)
does NOT always work.

Example: coins = [1, 3, 4], target = 6
- Greedy picks: 4 + 1 + 1 = **3 coins** ❌
- DP finds:     3 + 3     = **2 coins** ✅

DP tries ALL options and always finds the true minimum.

---

## Time and Space Complexity

| | Complexity | Plain English |
|---|---|---|
| Time | O(N × C) | For each amount, try each coin once |
| Space | O(N) | One box stored per amount |

Where:
- N = target amount
- C = number of coin types

---

## How to Run the Program

### Requirements:
- Java JDK 8 or higher
- Any Java IDE (NetBeans, IntelliJ, Eclipse) or command line

### Steps:
1. Clone or download this repository
2. Open `src/Final_Project.java` in your IDE
3. Run the program
4. Enter the target amount when prompted
5. Enter the number of coin types
6. Enter the coin denominations separated by spaces


## Video Presentation
[https://drive.google.com/file/d/1pz55OpUFkTY1BjsoBuR0lpHTsIYBuNFX/view?usp=sharing]

---

## AI Usage Declaration

I used Claude AI as a learning assistant throughout this project.
Claude helped me understand Dynamic Programming from scratch,
explained each step , and guided me through writing and debugging the code line by line.
I understand every part of the code and can explain it fully.
