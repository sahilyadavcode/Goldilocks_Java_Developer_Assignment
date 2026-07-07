/*
10.	Write a program to find the multiple occurrences of same value in the file.
A csv file contain column, say col1, col2, col3. You need to find the count of
records which has the same value of col3.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Question10 {
    public static void main(String[] args) {
        String csvFile = "Question10.csv"; 
        String line;
        String csvSplitBy = ",";

        Map<String, Integer> col3Counts = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
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

        System.out.println("Duplicate values in col3:");
        for (Map.Entry<String, Integer> entry : col3Counts.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " → " + entry.getValue() + " times");
            }
        }
    }
}

/*
TEST CASES:
Duplicate values in col3 → printed with count.

Unique values → not printed.

Empty file → no output.
*/

//TIME TAKEN: 35MIN
