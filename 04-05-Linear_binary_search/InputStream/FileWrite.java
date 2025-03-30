import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FileWrite {

    public static void main(String[] args) {

        System.out.println("enter the file name");
        Scanner sc = new Scanner(System.in);
        String filename = sc.nextLine();

        try {
            InputStreamReader sr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(sr);
            FileWriter fw = new FileWriter(filename);

            System.out.println("Enter text (type 'exit' to stop):");
            String line;

            while (!(line = br.readLine()).equalsIgnoreCase("exit")) {
                fw.write(line + "\n");
                // fw.newLine();
                fw.flush();
            }

            System.out.println("User input has been saved to " + filename);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}