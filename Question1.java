/*
1.	Write a function to convert a decimal number string into binary string. 
For example, string A contains “123” which is decimal value 123.
Convert this string into binary string.
*/


public class Question1 {

    // Function to convert decimal string to binary string
    public static String decimalToBinary(String decimalString) {
        // Parse the string into an integer
        int decimalValue = Integer.parseInt(decimalString);

        // Convert integer to binary string
        String binaryString = Integer.toBinaryString(decimalValue);

        return binaryString;
    }

    // Example usage
    public static void main(String[] args) {
        String decimalInput = "123";
        String binaryOutput = decimalToBinary(decimalInput);

        System.out.println("Decimal: " + decimalInput);
        System.out.println("Binary: " + binaryOutput);
    }
}

