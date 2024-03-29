

public class BloodData {
    enum BloodGroup {
        O, A, B, AB;
    }
    BloodGroup blood_type;
    char rh;

    public BloodData() {
        this.blood_type = BloodGroup.O;
        this.rh = '+';
    }

    public BloodData(BloodGroup blood_type, char rh) {
        this.blood_type = BloodGroup.O;
        this.rh = '+';
    }

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

    public void display() {
        System.out.println("Blood Type: " + blood_type);
        System.out.println("Rh Factor: " + rh);
    }
}
