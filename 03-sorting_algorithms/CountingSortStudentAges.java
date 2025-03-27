import java.util.Scanner;

public class CountingSortStudentAges {
    public static void countingSort(int[] ages) {
        int n = ages.length;
        int range = 18 - 10 + 1; // Age range: 10 to 18

        int[] count = new int[range];
        int[] output = new int[n];

        for (int age : ages) {
            count[age - 10]++;
        }

        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[ages[i] - 10] - 1] = ages[i];
            count[ages[i] - 10]--;
        }

        System.arraycopy(output, 0, ages, 0, n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();

        int[] ages = new int[n];
        System.out.println("Enter the ages of the students (between 10 and 18):");

        for (int i = 0; i < n; i++) {
            ages[i] = sc.nextInt();
        }

        countingSort(ages);

        System.out.println("Student ages in ascending order:");
        for (int age : ages) {
            System.out.print(age + " ");
        }
    }
}
