import java.io.*;

public class ReadFileByLine {
    public static void main(String[] args) {
        String filePath = "myfile.txt";

        try (FileReader fr = new FileReader(filePath);
                BufferedReader br = new BufferedReader(fr)) {

            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line); // Print each line
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}