package hala.final_project;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Final_Project {
    public static int coinChange(int[] coins, int target, int[] coinUsed) {

        // Step 1: Create the dp table with target+1 boxes
        // We add +1 because we need box 0 all the way to box "target"
        int[] dp = new int[target + 1];

        // Step 2: Fill every box with a big number (means "not solved yet")
        Arrays.fill(dp, target + 1);

        // Step 3: Base case — box 0 always costs 0 coins
        dp[0] = 0;

        // Step 4: Go through every box from 1 to target
        for (int amount = 1; amount <= target; amount++) {

            // Step 5: At each box, try every coin we have
            for (int coin : coins) {

                // Step 6: Check if this coin actually fits (doesn't go negative)
                //Example: if we are at box 2, we can't try a coin worth 4
                if (coin <= amount) {

                    // Step 7: Check if using this coin gives a better answer
                    // +1 is The one coin I am holding in my hand RIGHT NOW that I just decided to use
                    if (dp[amount - coin] + 1 < dp[amount]) {

                        // Step 8: Update dp table with the better answer
                        dp[amount] = dp[amount - coin] + 1;

                        // Step 9: Save which coin type gave us this better answer
                        coinUsed[amount] = coin;
                    }
                }
            }
        }

        // Step 10: Return the answer for our target box
        return dp[target];
    }

    public static List<Integer> findCoinsUsed(int[] coinUsed, int target) {

        // Step 1: Create an empty list to collect our coins
        List<Integer> result = new ArrayList<>();

        // Step 2: Start at the target box and work backwards
        int remaining = target;

        // Step 3: Keep jumping back until we reach box 0
        while (remaining > 0) {

            // Step 4: Grab the coin type used at current box
            int coin = coinUsed[remaining];

            // Step 5: Add that coin to our result list
            result.add(coin);

            // Step 6: Jump back to the box we came from
            remaining = remaining - coin;
        }

        // Step 7: Return the complete list of coins used
        return result;
    }
    
    public static void printResult(int minCoins, List<Integer> coinsUsed, int target) {

        // Step 1: Check if the target is impossible to reach
        if (minCoins > target) {

            // Step 2: Tell the user it's impossible
            System.out.println("Sorry! Amount " + target + " cannot be made with the given coins.");

        } else {

            // Step 3: Print the minimum number of coins
            System.out.println("Target amount: " + target);
            System.out.println("Minimum coins needed: " + minCoins);

            // Step 4: Print which coins were used
            System.out.print("Coins used: ");
            for (int coin : coinsUsed) {
                System.out.print(coin + " ");
            }
            System.out.println();
        }
}
    public static void main(String[] args) {

        // Step 1: Create a Scanner to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Step 2: Ask the user for the target amount
        System.out.print("Enter target amount: ");
        int target = scanner.nextInt();

        // Step 3: Ask the user how many coin types they have
        System.out.print("Enter number of coin types: ");
        int numCoins = scanner.nextInt();

        // Step 4: Create the coins array with that size
        int[] coins = new int[numCoins];

        // Step 5: Ask the user to enter each coin type one by one
        System.out.print("Enter coin denominations separated by spaces: ");
        for (int i = 0; i < numCoins; i++) {
            coins[i] = scanner.nextInt();
        }

        // Step 6: Create the coinUsed table (shared notebook between workers)
        int[] coinUsed = new int[target + 1];
        Arrays.fill(coinUsed, -1);

        // Step 7: Call the brain worker to run the DP logic
        int minCoins = coinChange(coins, target, coinUsed);
        if (minCoins > target) {
            // Impossible - pass an empty list to printResult
            printResult(minCoins, new ArrayList<>(), target);
        } else {
            // Valid answer - trace back then print
            List<Integer> coinsUsed = findCoinsUsed(coinUsed, target);
            printResult(minCoins, coinsUsed, target);
        }
        scanner.close();
    }
}
