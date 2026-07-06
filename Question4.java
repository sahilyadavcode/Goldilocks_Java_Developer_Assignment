import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Question4 {
    public static void main(String[] args) {
        String urlString = "http://127.0.0.1:8999/test?value=p";

        try {
            // Create URL object
            URL url = new URL(urlString);

            // Open connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set request method
            conn.setRequestMethod("GET");

            // Check response code
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read response
                try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    String inputLine;
                    StringBuilder response = new StringBuilder();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine).append("\n");
                    }

                    // Print output
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

