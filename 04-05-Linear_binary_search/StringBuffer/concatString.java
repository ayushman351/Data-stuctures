public class concatString {

    public static String concatination(String[] arr){

        StringBuffer sb = new StringBuffer();

        for(String str :arr){
            sb.append(str);
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        
        String[] arr = {"This "+ "is " + "array " + "string"};

        System.out.println( concatination(arr));
       

    }
}