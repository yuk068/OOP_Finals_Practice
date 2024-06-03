package yukwork.statistics.samplemanager.studentmanager;

public class Student {

    private String id;
    private String firstName;
    private String lastName;
    private int yearOfBirth;

    private double averageGrade;
    private double mathsGrade;
    private double physicsGrade;
    private double chemistryGrade;

    public static class StudentBuilder {

        private final String id;
        private String firstName;
        private String lastName;
        private int yearOfBirth;

        private double mathsGrade;
        private double physicsGrade;
        private double chemistryGrade;

        public StudentBuilder(String id) {
            this.id = id;
        }

        public StudentBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public StudentBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public StudentBuilder withYearOfBirth(int yearOfBirth) {
            this.yearOfBirth = yearOfBirth;
            return this;
        }

        public StudentBuilder withMathsGrade(double mathsGrade) {
            this.mathsGrade = mathsGrade;
            return this;
        }

        public StudentBuilder withPhysicsGrade(double physicsGrade) {
            this.physicsGrade = physicsGrade;
            return this;
        }

        public StudentBuilder withChemistryGrade(double chemistryGrade) {
            this.chemistryGrade = chemistryGrade;
            return this;
        }

        public Student build() {
            Student student = new Student();
            student.id = this.id;
            student.firstName = this.firstName;
            student.lastName = this.lastName;
            student.yearOfBirth = this.yearOfBirth;
            student.mathsGrade = this.mathsGrade;
            student.physicsGrade = this.physicsGrade;
            student.chemistryGrade = this.chemistryGrade;
            student.averageGrade = (this.mathsGrade +
                    this.physicsGrade +
                    this.chemistryGrade) / 3.0;
            return student;
        }

    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public double getMathsGrade() {
        return mathsGrade;
    }

    public double getPhysicsGrade() {
        return physicsGrade;
    }

    public double getChemistryGrade() {
        return chemistryGrade;
    }

    @Override
    public String toString() {
        return "[(" + id + "):" + firstName + " " + lastName +
                ";YoB:" + yearOfBirth + ";GPA:" + String.format("%.2f", averageGrade) +
                ";M:" + String.format("%.2f", mathsGrade) + ";P:" + String.format("%.2f", physicsGrade) +
                ";C:" + String.format("%.2f", chemistryGrade) + "]";
    }

}
