# Test Cases — Coin Change Problem

## Test 1 — Normal Case (Greedy Fails)
**Input:**
- Target amount: 6
- Coin denominations: [1, 3, 4]

**Expected Output:**
- Minimum coins needed: 2
- Coins used: 3 3

**Why this test matters:**
This test proves why greedy does not always work.
The greedy approach would pick 4+1+1 = 3 coins.
But DP finds the better answer of 3+3 = 2 coins.

---

## Test 2 — Normal Case (Real World Coins)
**Input:**
- Target amount: 36
- Coin denominations: [1, 5, 10, 25]

**Expected Output:**
- Minimum coins needed: 3
- Coins used: 25 10 1

**Why this test matters:**
This simulates real life US coins making 36 cents.
A normal everyday use case of the coin change problem.

---

## Test 3 — Edge Case (Impossible Amount)
**Input:**
- Target amount: 3
- Coin denominations: [2]

**Expected Output:**
- Sorry! Amount 3 cannot be made with the given coins.

**Why this test matters:**
This is an edge case because no combination of coins
can ever reach the target. The program must handle
this gracefully without crashing.

---

## Test 4 — Edge Case (Target is Zero)
**Input:**
- Target amount: 0
- Coin denominations: [1, 5, 10]

**Expected Output:**
- Minimum coins needed: 0
- Coins used: (empty)

**Why this test matters:**
This is an edge case because zero is the extreme low
end of all possible targets. The answer is always 0
coins no matter what denominations are given.
This tests our base case dp[0] = 0.
