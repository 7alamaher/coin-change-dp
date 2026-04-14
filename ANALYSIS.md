# Analysis — Coin Change Problem

## What Problem Are We Solving?

Given a list of coin denominations and a target amount,
find the minimum number of coins needed to reach that
target, and identify exactly which coins were used.

Example:
- Coins available: [1, 3, 4]
- Target: 6
- Answer: 2 coins → 3 + 3

---

## Why is This Problem Tricky?

The simple approach called "Greedy Strategy" says:
> "Always pick the biggest coin that fits"

Sounds smart! But Greedy FAILS in certain cases.

Example WHERE IT FAILS with coins [1, 3, 4] and target 6:
- Greedy will say:
  * Grab the biggest coin that fits → 4  (remaining: 2)
  * Grab the biggest coin that fits → 1  (remaining: 1)
  * Grab the biggest coin that fits → 1  (remaining: 0)
  * Total: 4 + 1 + 1 = 3 coins ❌

- Correct answer: 3 + 3 = 2 coins ✅

We need a smarter approach — Dynamic Programming.
Instead of solving the problem all at once, DP breaks
it into smaller problems, solves them one by one,
saves each answer, and builds up to the final answer.

---

## How Does Our Algorithm Work?

### Step by Step Explanation:

**Step 1 — Build a table**
Create an array called dp[] with one box for
every amount from 0 to target.
Each box stores the minimum coins needed to
reach that amount.

**Step 2 — Set the base case**
dp[0] = 0
Making zero cents always costs zero coins.

**Step 3 — Fill every other box with a big number**
We use target+1 as our "not solved yet" number.
This means we haven't found a solution for that
amount yet.

**Step 4 — Fill the table box by box**
For every amount from 1 to target:
  For every coin available:
    If the coin fits (coin <= amount):
      Look back at dp[amount - coin]
      Add 1 (for the coin we just used)
      If this is better than what we have:
        Update dp[amount]
        Save which coin we used in coinUsed[]

**Step 5 — Trace back the coins used**
Start at the target box.
Look at which coin was saved there.
Subtract that coin and jump to the previous box.
Repeat until we reach box 0.
Collect all coins along the way.

**Step 6 — Print the result**
If dp[target] is still bigger than target →
the amount is impossible.
Otherwise print the minimum coins and which
coins were used.

---

## Pseudocode:

```
function coinChange(coins, target):
    dp[0] = 0
    dp[1..target] = target + 1
    coinUsed[0..target] = -1

    for amount from 1 to target:
        for each coin in coins:
            if coin <= amount:
                if dp[amount - coin] + 1 < dp[amount]:
                    dp[amount] = dp[amount - coin] + 1
                    coinUsed[amount] = coin

    return dp[target]


function findCoinsUsed(coinUsed, target):
    result = empty list
    remaining = target

    while remaining > 0:
        coin = coinUsed[remaining]
        add coin to result
        remaining = remaining - coin

    return result
```

---

## Time Complexity — O(N × C)

| Variable | Meaning |
|---|---|
| N | The target amount |
| C | The number of coin types |

What we do:
- We visit every single box from 0 to N → that is N boxes
- At each box we try every single coin → that is C coins
- The total work is N × C

We have two nested loops:
- Outer loop runs N times (once per amount)
- Inner loop runs C times (once per coin)
- Total work = N × C operations

Example:
- Target = 36, Coins = 4 types
- Work = 36 × 4 = 144 operations

If target doubles → work doubles.
Very predictable and manageable growth. ✅

---

## Space Complexity — O(N)

We create one box for every amount from 0 to target,
which is N+1 boxes stored in memory.

We store two arrays:
- dp[]       → size N+1
- coinUsed[] → size N+1

In complexity we simplify 2(N+1) → O(N)
because constants and small additions are always
dropped as they do not affect how the solution grows.

Total space = O(N) ✅

---

## Why Does DP Work Here?

DP works because this problem has two key properties:

**Property 1 — Overlapping Subproblems**
To solve amount 6, we need the answer for amount 3.
To solve amount 3, we need the answer for amount 0.
The same smaller problems appear again and again.
DP solves each one ONCE and saves the answer.

**Property 2 — Optimal Substructure**
The best solution for a big amount is built from
the best solutions of smaller amounts.
If the best way to make 3 cents uses 1 coin,
then any solution that passes through 3 cents
can use that same 1 coin answer.

These two properties together make DP the
perfect tool for the Coin Change Problem.
