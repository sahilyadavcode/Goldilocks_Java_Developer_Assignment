

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Question10 {
    public static void main(String[] args) {
        String csvFile = "data.csv"; // replace with your CSV file path
        String line;
        String csvSplitBy = ",";

        // Map to store counts of col3 values
        Map<String, Integer> col3Counts = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Skip header line if present
            String header = br.readLine();

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(csvSplitBy);

                if (columns.length >= 3) {
                    String col3Value = columns[2].trim(); // col3 is index 2
                    col3Counts.put(col3Value, col3Counts.getOrDefault(col3Value, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print values that occur more than once
        System.out.println("Duplicate values in col3:");
        for (Map.Entry<String, Integer> entry : col3Counts.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " → " + entry.getValue() + " times");
            }
        }
    }
}

