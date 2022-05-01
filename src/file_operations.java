import java.io.File;
import java.util.Scanner;

public class file_operations {
    static File check_file_exists(String filename, String... args) {
        // To read argument which is list of strings [Not used in this use case]
        for (String arg : args) {
            System.out.println(arg);
        }
        File file = new File(filename);
        if (file.exists() && !file.isDirectory()) {
            System.out.println("File exists: " + file.getName());
            return file;
        } else {
            System.out.println("File does not exist. Checking in " + System.getProperty("user.dir"));
        }

        var file_path2 = System.getProperty("user.dir") + "/src/" + filename;
        File new_file = new File(file_path2);
        if (new_file.exists() && !file.isDirectory()) {
            System.out.println("File `" + new_file.getName() + "` exists at " + System.getProperty("user.dir"));
            return new_file;
        } else {
            System.out.println("File does not exist.");
        }
        return null;
    }

    public static void read_file(File filename) throws Exception {
        Scanner sc = new Scanner(filename);
        sc.useDelimiter("\\Z");
        System.out.println(sc.next());
    }

    public static void read_file_chunks(File filename) throws Exception {
        Scanner sc_ = new Scanner(filename);
        while (sc_.hasNextLine())
            System.out.println(sc_.nextLine());
    }

    public static void main(String[] args) throws Exception {
        var FILENAME = System.getenv().getOrDefault("FILENAME", "data.txt");
        var file = check_file_exists(FILENAME);
        if (file != null) {
            System.out.println();
            read_file(file);
            read_file_chunks(file);
        } else {
            System.exit(1);
        }
    }
}
