
/*


*/


import java.io.*;

public class Question2 {
    public static void main(String[] args) {
        // Input and output file paths
        String inputFile = "input.csv";
        String outputFile = "output.csv";

        try (
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))
        ) {
            String line;

            while ((line = br.readLine()) != null) {
                // Split the line by comma
                String[] values = line.split(",");

                // Parse numeric values
                int num1 = Integer.parseInt(values[0].trim());
                int num2 = Integer.parseInt(values[1].trim());
                int num3 = Integer.parseInt(values[2].trim());

                // Calculate sum
                int sum = num1 + num2 + num3;

                // Write original line + sum to output file
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
