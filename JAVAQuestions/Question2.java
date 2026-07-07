
/*
2.	Write a program to read a CSV file and print the same in the output file.
 This csv file contains three columns having numeric value.
The output file should additionally contain the sum of these numeric values.

*/


import java.io.*;

public class Question2 {
    public static void main(String[] args) {
        String inputFile = "input.csv";
        String outputFile = "output.csv";

        try (
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))
        ) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                int num1 = Integer.parseInt(values[0].trim());
                int num2 = Integer.parseInt(values[1].trim());
                int num3 = Integer.parseInt(values[2].trim());

                int sum = num1 + num2 + num3;

                bw.write(line + "," + sum);
                bw.newLine();
            }

            System.out.println("CSV file processed successfully. Output written to " + outputFile);

        } catch (IOException e) {
            System.err.println("Error reading/writing file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing number: " + e.getMessage());
        }
    }
}

/*
TEST CASES:
Input row 1,2,3 → Output row 1,2,3,6.

Negative numbers handled correctly.

Empty line → skip or error.

Large values → sum computed correctly.
*/
//TIME TAKEN: 12MIN
