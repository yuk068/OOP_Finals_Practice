package yukwork.statistics.samplemanager.studentmanager;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentManager {

    private static StudentManager instance;
    private final List<Student> studentList;

    private StudentManager() {
        studentList = new LinkedList<>();
    }

    public static StudentManager getInstance() {
        if (instance == null) {
            instance = new StudentManager();
        }
        return instance;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void append(Student student) {
        studentList.add(student);
    }

    public void add(Student student, int index) {
        studentList.add(index, student);
    }

    public void remove(int index) {
        studentList.remove(index);
    }

    public void remove(Student student) {
        studentList.remove(student);
    }

    public Student studentAt(int index) {
        return studentList.get(index);
    }

    public List<Student> sortYearOfBirthIncreasing() {
        return studentList.stream()
                .sorted(Comparator.comparingInt(Student::getYearOfBirth))
                .collect(Collectors.toList());
    }


    public List<Student> sortYearOfBirthDecreasing() {
        return studentList.stream()
                .sorted(Comparator.comparingInt(Student::getYearOfBirth).reversed())
                .collect(Collectors.toList());
    }

    public List<Student> sortMathsGradeIncreasing() {
        return studentList.stream()
                .sorted(Comparator.comparingDouble(Student::getMathsGrade))
                .collect(Collectors.toList());
    }

    public List<Student> sortMathsGradeDecreasing() {
        return studentList.stream()
                .sorted(Comparator.comparingDouble(Student::getMathsGrade).reversed())
                .collect(Collectors.toList());
    }

    public List<Student> sortPhysicsGradeIncreasing() {
        return studentList.stream()
                .sorted(Comparator.comparingDouble(Student::getPhysicsGrade))
                .collect(Collectors.toList());
    }

    public List<Student> sortPhysicsGradeDecreasing() {
        return studentList.stream()
                .sorted(Comparator.comparingDouble(Student::getPhysicsGrade).reversed())
                .collect(Collectors.toList());
    }

    public List<Student> sortChemistryGradeIncreasing() {
        return studentList.stream()
                .sorted(Comparator.comparingDouble(Student::getChemistryGrade))
                .collect(Collectors.toList());
    }

    public List<Student> sortChemistryGradeDecreasing() {
        return studentList.stream()
                .sorted(Comparator.comparingDouble(Student::getChemistryGrade).reversed())
                .collect(Collectors.toList());
    }

    public List<Student> sortAverageGradeIncreasing() {
        return studentList.stream()
                .sorted(Comparator.comparingDouble(Student::getAverageGrade))
                .collect(Collectors.toList());
    }

    public List<Student> sortAverageGradeDecreasing() {
        return studentList.stream()
                .sorted(Comparator.comparingDouble(Student::getAverageGrade).reversed())
                .collect(Collectors.toList());
    }

    public List<Student> filterStudentsHighestPhysicsGrade(int howMany) {
        return studentList.stream()
                .sorted(Comparator.comparingDouble(Student::getPhysicsGrade))
                .limit(howMany)
                .collect(Collectors.toList());
    }

    public List<Student> filterStudentsHigherThanPhysicsGrade(double lowerBoundGrade) {
        return studentList.stream()
                .filter(student -> student.getPhysicsGrade() > lowerBoundGrade)
                .collect(Collectors.toList());
    }

    public List<Student> filterStudentsLowestPhysicsGrade(int howMany) {
        return studentList.stream()
                .sorted(Comparator.comparingDouble(Student::getPhysicsGrade).reversed())
                .limit(howMany)
                .collect(Collectors.toList());
    }

    public List<Student> filterStudentsLowerThanPhysicsGrade(double upperBoundGrade) {
        return studentList.stream()
                .filter(student -> student.getPhysicsGrade() < upperBoundGrade)
                .collect(Collectors.toList());
    }

    public List<Student> filterStudentsHighestMathsGrade(int howMany) {
        return studentList.stream()
                .sorted(Comparator.comparingDouble(Student::getMathsGrade).reversed())
                .limit(howMany)
                .collect(Collectors.toList());
    }

    public List<Student> filterStudentsHigherThanMathsGrade(double lowerBoundGrade) {
        return studentList.stream()
                .filter(student -> student.getMathsGrade() > lowerBoundGrade)
                .collect(Collectors.toList());
    }

    public List<Student> filterStudentsLowestMathsGrade(int howMany) {
        return studentList.stream()
                .sorted(Comparator.comparingDouble(Student::getMathsGrade))
                .limit(howMany)
                .collect(Collectors.toList());
    }

    public List<Student> filterStudentsLowerThanMathsGrade(double upperBoundGrade) {
        return studentList.stream()
                .filter(student -> student.getMathsGrade() < upperBoundGrade)
                .collect(Collectors.toList());
    }

    public List<Student> filterStudentsHighestChemistryGrade(int howMany) {
        return studentList.stream()
                .sorted(Comparator.comparingDouble(Student::getChemistryGrade).reversed())
                .limit(howMany)
                .collect(Collectors.toList());
    }

    public List<Student> filterStudentsHigherThanChemistryGrade(double lowerBoundGrade) {
        return studentList.stream()
                .filter(student -> student.getChemistryGrade() > lowerBoundGrade)
                .collect(Collectors.toList());
    }

    public List<Student> filterStudentsLowestChemistryGrade(int howMany) {
        return studentList.stream()
                .sorted(Comparator.comparingDouble(Student::getChemistryGrade))
                .limit(howMany)
                .collect(Collectors.toList());
    }

    public List<Student> filterStudentsLowerThanChemistryGrade(double upperBoundGrade) {
        return studentList.stream()
                .filter(student -> student.getChemistryGrade() < upperBoundGrade)
                .collect(Collectors.toList());
    }

    public List<Student> filterStudentsHighestAverageGrade(int howMany) {
        return studentList.stream()
                .sorted(Comparator.comparingDouble(Student::getAverageGrade).reversed())
                .limit(howMany)
                .collect(Collectors.toList());
    }

    public List<Student> filterStudentsHigherThanAverageGrade(double lowerBoundGrade) {
        return studentList.stream()
                .filter(student -> student.getAverageGrade() > lowerBoundGrade)
                .collect(Collectors.toList());
    }

    public List<Student> filterStudentsLowestAverageGrade(int howMany) {
        return studentList.stream()
                .sorted(Comparator.comparingDouble(Student::getAverageGrade))
                .limit(howMany)
                .collect(Collectors.toList());
    }

    public static String idOfStudentsToString(List<Student> studentList) {
        StringBuilder idOfStudents = new StringBuilder();
        idOfStudents.append("[");
        for (Student student : studentList) {
            idOfStudents.append(student.getId()).append(" ");
        }
        return idOfStudents.toString().trim() + "]";
    }

    public static void print(List<Student> studentList) {
        StringBuilder studentsString = new StringBuilder();
        studentsString.append("[\n");
        for (Student student : studentList) {
            studentsString.append(student.toString()).append("\n");
        }
        System.out.print(studentsString.toString().trim() + "\n]");
    }

}