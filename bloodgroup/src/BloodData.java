// Enum for bloodgroup
enum BloodGroup {
    O, A, B, AB;
}

public class BloodData {
    BloodGroup blood_type;
    char rh;

    // BloodData default constructor
    public BloodData() {
        this.blood_type = BloodGroup.O;
        this.rh = '+';
    }

    // BloodData overloaded constructor
    public BloodData(BloodGroup blood_type, char rh) {
        this.blood_type = blood_type;
        this.rh = rh;
    }

    // Getters and setters
    public BloodGroup getBloodType() {
        return blood_type;
    }

    public void setBloodType(BloodGroup bloodType) {
        this.blood_type = blood_type;
    }

    public char getRh() {
        return rh;
    }
    public void setRh(char rh) {
        this.rh = rh;
    }

    // Display method for convenience
    public void display() {
        System.out.println("Blood Type: " + this.getBloodType());
        System.out.println("Rh Factor: " + this.getRh());
    }
}
