public class Patient {
    int id_number;
    int age;
    BloodData blood_data;

    // Patient default contructor
    public Patient() {
        this.id_number = 0;
        this.age = 0;
        this.blood_data = new BloodData();
    }

    // Patient overloaded constructor contructor
    public Patient(int id_number, int age, BloodData blood_data) {
        this.id_number = id_number;
        this.age = age;
        this.blood_data = blood_data;
    }

    // Getters
    public int getIdNumber() {
        return id_number;
    }

    public int getAge() {
        return age;
    }

    public BloodData getBloodData() {
        return blood_data;
    }

    // Display method for convenience
    public void display() {
        System.out.println("id " + this.getIdNumber());
        System.out.println("age " + this.getAge());
        this.getBloodData().display();
    }
}
