import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class web_operations_POST {
    public static boolean healthy(String url_env) throws Exception {
        try {
            URL url = new URL(url_env + "/health");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            if (connection.getResponseCode() == 200) {
                return true;
            } else {
                System.out.println(connection.getResponseCode() + " - " + connection.getResponseMessage());
            }
        } catch (UnknownHostException | HttpRetryException | SocketException error) {
            System.out.println(error.getClass());
        }
        return false;
    }

    public static String postHTML(String url_env, String token) throws Exception {
        try {
            URL url = new URL(url_env + "/offline-communicator");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            var HTTP_PROXY = System.getenv("HTTP_PROXY");
            var HTTPS_PROXY = System.getenv("HTTPS_PROXY");
            if (HTTP_PROXY != null) {
                connection.setRequestProperty("HTTP_PROXY", HTTP_PROXY);
            }
            if (HTTPS_PROXY != null) {
                connection.setRequestProperty("HTTPS_PROXY", HTTPS_PROXY);
            }
            connection.setRequestProperty("Authorization", "Bearer " + token);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);
            String data = "{\n  \"command\": \"turn off kitchen lights\"\n}";
            byte[] out = data.getBytes(StandardCharsets.UTF_8);
            OutputStream stream = connection.getOutputStream();
            stream.write(out);
            System.out.println(connection.getResponseCode() + " " + connection.getResponseMessage());
            if (connection.getResponseCode() == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder stringify = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    stringify.append(line);
                }
                connection.disconnect();
                return stringify.toString();
            }
            connection.disconnect();
        } catch (ConnectException | UnknownHostException | HttpRetryException | MalformedURLException error) {
            System.out.println(error.getClass());
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        var url_env = System.getenv("URL");
        var token = System.getenv("AUTH");
        if (url_env == null) {
            System.out.println("No URL has been stored as env var");
            System.exit(1);
        }
        if (token == null) {
            System.out.println("Auth token is missing");
            System.exit(1);
        }
        if (!healthy(url_env)) {
            System.out.println(url_env + " is not healthy.");
            System.exit(1);
        }
        var post_response = postHTML(url_env, token);
        if (post_response != null) {
            System.out.println(post_response);
        }
    }
}
