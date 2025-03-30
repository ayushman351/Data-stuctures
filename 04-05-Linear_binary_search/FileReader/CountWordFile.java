import java.io.BufferedReader;
import java.io.FileReader;

public class CountWordFile {
    public static void main(String[] args) {

        String filepath = "myfile.txt";
        String text  = "hello";


        try {

            FileReader fr = new FileReader(filepath);

            BufferedReader br = new BufferedReader(fr);

            String line;
            int count =0;

            while((line = br.readLine())!=null){
                String[] word = line.split(" ");

                for(int i=0; i<word.length; i++){
                    if(text.equals(word[i])){
                        count++;
                    }
                }

            }

            System.out.println(count);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Exception: " + e);
        }

    }
}