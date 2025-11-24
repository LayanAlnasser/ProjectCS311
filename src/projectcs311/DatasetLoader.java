package projectcs311;

import java.io.File;
import java.util.*;


public class DatasetLoader {
        public static List<Item> loadDataset(String filename) throws Exception {
        Scanner sc = new Scanner(new File("datasets/" + filename));
        int n = sc.nextInt();
        int capacity = sc.nextInt();

        List<Item> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            int weight = sc.nextInt();
            items.add(new Item(value, weight));
        }
        sc.close();

        System.out.println("Loaded " + n + " items, capacity = " + capacity);
        return items;
    }

    public static List<String> listDatasets() {
        File folder = new File("datasets/");
        String[] files = folder.list((dir, name) -> name.endsWith(".txt"));
        return files != null ? Arrays.asList(files) : new ArrayList<>();
    }

}
