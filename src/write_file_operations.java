import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class write_file_operations {
    public static boolean create_file(String filename) {
        try {
            File file_object = new File(filename);
            if (file_object.createNewFile()) {
                System.out.println("File created: " + file_object.getName());
            } else {
                System.out.println("File already exists.");
            }
            return true;
        } catch (IOException error) {
            System.out.println("An error occurred.");
            error.printStackTrace();
            return false;
        }
    }

    public static void write_data(String filename, String data) {
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write(data);
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        var FILENAME = System.getenv().getOrDefault("FILENAME", "filename.txt");
        if (create_file(FILENAME)) {
            write_data("filename.txt", "Neutron Stars are one of the most extreme and violent things " +
                    "in the Universe.\n");
        }
    }
}
