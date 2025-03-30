public class CompareTime {

    public static long concatStringBuffer(String str) {

        StringBuffer sb = new StringBuffer();

        long t1 = System.nanoTime();

        for (int i = 0; i < 1000000; i++) {
            sb.append(str);
        }

        long t2 = System.nanoTime();

        return t2 - t1;

    }

    public static long concatStringBuilder(String str) {
        StringBuilder sb = new StringBuilder();

        long t1 = System.nanoTime();

        for (int i = 0; i < 1000000; i++) {
            sb.append(str);
        }

        long t2 = System.nanoTime();

        return t2 - t1;
    }

    public static void main(String[] args) {

        String str = "hello";

        long timeBuffer = concatStringBuffer(str);
        System.out.println("Time taken by StringBuffer: " + timeBuffer + " ns");

     
        long timeBuilder = concatStringBuilder(str);
        System.out.println("Time taken by StringBuilder: " + timeBuilder + " ns");
    }
}