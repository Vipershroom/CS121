import java.util.Arrays;
import java.util.Scanner;
public class TestPatient {

    public static int[] prompt() {
        Scanner s = new Scanner(System.in);
        int id;
        int age;

        while (true) {
            System.out.println("Please enter your id");
            try {
                id = Integer.parseInt(s.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Please enter a number");
                continue;
            }

        }
        while (true) {
            System.out.println("Please enter your age");
            try {
                age = Integer.parseInt(s.nextLine());;
                break;
            } catch (Exception e) {
                System.out.println("Please enter a number");
            }

        }
        return new int[]{id, age};
    }


    public static void main(String[] args) {

        Patient patient1 = new Patient();
        patient1.display();
        // Prompt user for patient info
        int[] patient2_data = prompt();

        // Get blood group info
        Scanner s = new Scanner(System.in);
        String[] blood_type_arr = {"O", "A", "B", "AB"};
        String rh;
        BloodGroup blood;
        while (true) {
            System.out.println("Please enter your blood type");
            System.out.println("O A B AB");
            String blood_type = s.nextLine().toUpperCase();
            if (Arrays.stream(blood_type_arr).anyMatch(b -> b.contains(blood_type))) {
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

        while (true) {
            System.out.println("Please enter your rh factor (-/+)");
            rh = s.nextLine();
            if (rh.equals("-") || rh.equals("+")) {
                break;
            }
            System.out.println("Please enter a valid rh factor\n");
        }

        // Initialize patient 2
        Patient patient2 = new Patient(patient2_data[0], patient2_data[1], new BloodData(blood, rh.toCharArray()[0]));
        patient2.display();
        // Initialize patient 3
        int[] patient3_data = prompt();
        Patient patient3 = new Patient(patient3_data[0], patient3_data[1], new BloodData());
        patient3.display();
    }


}
