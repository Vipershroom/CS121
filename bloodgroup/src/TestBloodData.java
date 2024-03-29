import java.util.Scanner;
import java.util.Arrays;
public class TestBloodData {
    public static void main(String[] args) {
        System.out.println("Hello, Welcome to Blood Data");
        Scanner s = new Scanner(System.in);
        String[] blood_type_arr = {"O", "A", "B", "AB"};

        while (true) {
            System.out.println("Please enter your blood type");
            System.out.println("O A B AB");
            String blood_type = s.nextLine().toUpperCase();
            if (Arrays.stream(blood_type_arr).anyMatch(b -> b.contains(blood_type))) {
                break;
            }
            System.out.println("Please enter a valid blood type");
        }

        while (true) {
            System.out.println("Please enter your rh factor (-/+)");
            String rh = s.nextLine();
            if (rh.equals("-") || rh.equals("+")) {
                break;
            }
            System.out.println("Please enter a valid rh factor\n");
        }

        BloodData data1 = new BloodData();

        // Get user input here
        BloodData data2 = new BloodData();
        data1.display();
    }
}
