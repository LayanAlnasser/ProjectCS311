/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projectcs311;

import java.io.*;
import java.util.*;

/**
 *
 * @author NorahAbdullah
 */
public class ProjectCS311 {

    public static void main(String[] args) throws Exception {
      Scanner input = new Scanner(System.in);

        // List all datasets
        List<String> datasets = DatasetLoader.listDatasets();
        System.out.println("Available datasets:");
        for (int i = 0; i < datasets.size(); i++) {
            System.out.println((i+1) + ". " + datasets.get(i));
        }

        System.out.print("Choose dataset number: ");
        int choice = input.nextInt();
        String filename = datasets.get(choice-1);

        List<Item> items = DatasetLoader.loadDataset(filename);

        System.out.println("Select algorithm:");
        System.out.println("1. Greedy Ratio (Fractional)");
        System.out.println("2. Greedy Value (0-1)");
        System.out.println("3. Random Sampling (0-1)");
        System.out.println("4. Monte Carlo (0-1)");
        int algo = input.nextInt();

        // Extract capacity from file again
        Scanner sc = new Scanner(new File("datasets/" + filename));
        sc.nextInt(); // skip n
        int capacity = sc.nextInt();
        sc.close();

        double result = 0;
        switch (algo) {
            case 1 -> result = KnapsackSolver.greedyRatio(items, capacity, true);
            case 2 -> result = KnapsackSolver.greedyValue(items, capacity);
            case 3 -> result = KnapsackSolver.randomSampling(items, capacity);
            case 4 -> result = KnapsackSolver.monteCarlo(items, capacity, 1000);
        }

        System.out.println("Result = " + result);
    }
}





