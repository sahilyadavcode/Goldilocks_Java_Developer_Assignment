/*
1.	Write a function to convert a decimal number string into binary string. 
For example, string A contains “123” which is decimal value 123.
Convert this string into binary string.
*/


public class Question1 {

    public static String decimalToBinary(String decimalString) {
        
        int decimalValue = Integer.parseInt(decimalString);

        
        String binaryString = Integer.toBinaryString(decimalValue);

        return binaryString;
    }


    public static void main(String[] args) {
        String decimalInput = "123";
        String binaryOutput = decimalToBinary(decimalInput);

        System.out.println("Decimal: " + decimalInput);
        System.out.println("Binary: " + binaryOutput);
    }
}

/*
TEST CASES:
Input "123" → Output "1111011".

Input "0" → Output "0".

Input "255" → Output "11111111".

Invalid input "abc" → should throw NumberFormatException.
*/