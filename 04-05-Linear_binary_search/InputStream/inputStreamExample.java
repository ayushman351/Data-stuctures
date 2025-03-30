import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class inputStreamExample {
    public static void main(String[] args) {

        String filepath = "myfile.txt";
        // File fs = new File("myfile.txt");
        
        try {

            //FileInputStream is used to read data from a file as a stream of bytes
            FileInputStream  fs = new FileInputStream(filepath); 

            //InputStreamReader is a bridge from byte streams to character streams
            InputStreamReader sr = new InputStreamReader(fs,"UTF-8");  

           
            BufferedReader br = new BufferedReader(sr);
            
            String line;
            while((line = br.readLine()) !=null){
                System.out.println(line);
            }

            br.close();
            
            
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }catch(Exception e){
            System.out.println(e);
        }

    }
}