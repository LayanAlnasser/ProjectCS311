package projectcs311;

import java.io.*;
import java.util.*;

public class ProjectCS311 {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        // List all datasets
        List<String> datasets = DatasetLoader.listDatasets();
        System.out.println();
        System.out.println("Available datasets:");
        for (int i = 0; i < datasets.size(); i++) {
            System.out.println((i + 1) + ". " + datasets.get(i));
        }
        System.out.println();
        System.out.print("Choose dataset number: ");
        int choice = input.nextInt();
        System.out.println();
        String filename = datasets.get(choice - 1);

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
        long startTime = System.nanoTime();
        
        switch (algo) {
            case 1: 
                result = KnapsackSolver.greedyRatio(items, capacity, true);
                break;
            case 2: 
                result = KnapsackSolver.greedyValue(items, capacity);
                break;
            case 3: 
                result = KnapsackSolver.randomSampling(items, capacity);
                break;
            case 4: 
                result = KnapsackSolver.monteCarlo(items, capacity, 1000);
                break;
        }
        
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000; // Convert to milliseconds

        System.out.println("Result = " + result);
        System.out.println("Execution Time = " + duration + " ms");
    }
    
}