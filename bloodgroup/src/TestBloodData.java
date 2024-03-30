import java.util.Scanner;
import java.util.Arrays;
public class TestBloodData {
    public static void main(String[] args) {
        String rh;
        BloodGroup blood;
        System.out.println("Hello, Welcome to Blood Data");
        Scanner s = new Scanner(System.in);
        String[] blood_type_arr = {"O", "A", "B", "AB"};

        // Handle input for blood type
        while (true) {
            System.out.println("Please enter your blood type");
            System.out.println("O A B AB");
            String blood_type = s.nextLine().toUpperCase();
            if (Arrays.stream(blood_type_arr).anyMatch(b -> b.contains(blood_type))) {
                // Initialize input into an enum
                if (blood_type.equals("O")) {
                    blood = BloodGroup.O;
                } else if (blood_type.equals("A")) {
                    blood = BloodGroup.A;
                } else if (blood_type.equals("B")) {
                    blood = BloodGroup.B;
                } else {
                    blood = BloodGroup.AB;
                }
                break;
            }
            System.out.println("Please enter a valid blood type");
        }

        // Handle input for RH factor
        while (true) {
            System.out.println("Please enter your rh factor (-/+)");
            rh = s.nextLine();
            if (rh.equals("-") || rh.equals("+")) {
                break;
            }
            System.out.println("Please enter a valid rh factor\n");
        }

        BloodData data1 = new BloodData();

        BloodData data2 = new BloodData(blood, rh.toCharArray()[0]);
        data1.display();
        data2.display();

        data1.setBloodType(blood);
        data1.setRh(rh.toCharArray()[0]);
        data1.display();
    }
}
