import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

public class web_operations_GET {
    public static String getHTML(URL url) throws Exception {
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            var ok = connection.getResponseCode();
            if (ok >= 200 && ok <= 302) {
                StringBuilder result = new StringBuilder();
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                for (String line; (line = reader.readLine()) != null; ) {
                    var append_value = line + "\n";
                    result.append(append_value);
                }
                return result.toString();
            } else {
                throw new ConnectException();
            }
        } catch (ConnectException | UnknownHostException | HttpRetryException error) {
            System.out.println(error.getClass());
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        URL url = new URL("https://vigneshrao.com/");
        var get_response = getHTML(url);
        if (get_response != null) {
            System.out.println(get_response);
        }
    }
}
