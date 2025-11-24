/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectcs311;

import java.util.*;

/**
 *
 * @author NorahAbdullah
 */
public class KnapsackSolver {
    // Greedy Strategy 1: Value-to-weight ratio (Fractional + 0-1)

 public static double greedyRatio(List<Item> items, int capacity, boolean fractional) {
        items.sort((a, b) -> Double.compare(b.ratio(), a.ratio()));
        int remaining = capacity;
        double totalValue = 0;

        for (Item item : items) {
            if (remaining >= item.weight) {
                remaining -= item.weight;
                totalValue += item.value;
            } else if (fractional) {
                totalValue += item.ratio() * remaining;
                break;
            }
        }
        return totalValue;
    }


    // Greedy Strategy 2: Absolute value first (0-1 only)
    public static int greedyValue(List<Item> items, int capacity) {
        items.sort((a, b) -> Integer.compare(b.value, a.value));
        int remaining = capacity;
        int totalValue = 0;

        for (Item item : items) {
            if (remaining >= item.weight) {
                remaining -= item.weight;
                totalValue += item.value;
            }
        }
        return totalValue;
    }
    // Randomized Strategy 1: Random Sampling

    public static int randomSampling(List<Item> items, int capacity) {
        Random rand = new Random();
        int remaining = capacity;
        int totalValue = 0;

        List<Item> shuffled = new ArrayList<>(items);
        Collections.shuffle(shuffled, rand);

        for (Item item : shuffled) {
            if (remaining >= item.weight) {
                remaining -= item.weight;
                totalValue += item.value;
            }
        }
        return totalValue;
    }

    // Randomized Strategy 2: Monte Carlo Approximation
    public static int monteCarlo(List<Item> items, int capacity, int trials) {
        int bestValue = 0;
        Random rand = new Random();

        for (int t = 0; t < trials; t++) {
            int remaining = capacity;
            int totalValue = 0;

            List<Item> shuffled = new ArrayList<>(items);
            Collections.shuffle(shuffled, rand);

            for (Item item : shuffled) {
                if (remaining >= item.weight) {
                    remaining -= item.weight;
                    totalValue += item.value;
                }
            }
            bestValue = Math.max(bestValue, totalValue);
        }
        return bestValue;
    }

}
