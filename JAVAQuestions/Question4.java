/*
4.	Write a program to call a HTTP URL and print the output
a.	URL is http://127.0.0.1:8999/test?value=p

*/


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Question4 {
    public static void main(String[] args) {
        String urlString = "http://127.0.0.1:8999/test?value=p";

        try {
            URL url = new URL(urlString);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    String inputLine;
                    StringBuilder response = new StringBuilder();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine).append("\n");
                    }

                    System.out.println("Response from server:");
                    System.out.println(response.toString());
                }
            } else {
                System.out.println("Failed: HTTP error code : " + responseCode);
            }

        } catch (Exception e) {
            System.err.println("Error calling URL: " + e.getMessage());
        }
    }
}

/*
TEST CASES:

Server running → prints response.

Server down → throws IOException.

Different query parameter → response changes.
 */

//TIME TAKEN: 25MIN
