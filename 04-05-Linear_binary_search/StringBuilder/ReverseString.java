public class ReverseString {

    public static String reverseString(String str){
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "hello";
        System.out.println(reverseString(str));
    }
}