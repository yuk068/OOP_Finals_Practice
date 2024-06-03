package yukwork.statistics.samplemanager.candidatemanager;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentManager {

    private static StudentManager instance;
    private final MyList studentList;
    private static final boolean ARRAY_LIST_OR_LINKED_LIST = true;

    private StudentManager() {
        studentList = ARRAY_LIST_OR_LINKED_LIST ? new MyArrayList() : new MyLinkedList();
    }

    public static StudentManager getInstance() {
        if (instance == null) {
            instance = new StudentManager();
        }
        return instance;
    }

    public MyList getStudentList() {
        return studentList;
    }

    public void append(Student student) {
        studentList.append(student);
    }

    public void add(Student student, int index) {
        studentList.insert(student, index);
    }

    public void remove(int index) {
        studentList.remove(index);
    }

    public Student studentAt(int index) {
        return (Student) studentList.get(index);
    }

    public MyList sortYearOfBirthIncreasing() {
        List<Student> toSort = ARRAY_LIST_OR_LINKED_LIST ? new ArrayList<>() : new LinkedList<>();
        MyList sorted = ARRAY_LIST_OR_LINKED_LIST ? new MyArrayList() : new MyLinkedList();
        MyIterator iterator = studentList.iterator();
        while (iterator.hasNext()) toSort.add((Student) iterator.next());
        toSort.sort(Comparator.comparingInt(Student::getYearOfBirth));
        toSort.forEach(sorted::append);
        return sorted;
    }

    public MyList sortYearOfBirthDecreasing() {
        List<Student> toSort = ARRAY_LIST_OR_LINKED_LIST ? new ArrayList<>() : new LinkedList<>();
        MyList sorted = ARRAY_LIST_OR_LINKED_LIST ? new MyArrayList() : new MyLinkedList();
        MyIterator iterator = studentList.iterator();
        while (iterator.hasNext()) toSort.add((Student) iterator.next());
        toSort.sort(Comparator.comparingInt(Student::getYearOfBirth).reversed());
        toSort.forEach(sorted::append);
        return sorted;
    }

    public MyList sortMathsGradeIncreasing() {
        List<Student> toSort = ARRAY_LIST_OR_LINKED_LIST ? new ArrayList<>() : new LinkedList<>();
        MyList sorted = ARRAY_LIST_OR_LINKED_LIST ? new MyArrayList() : new MyLinkedList();
        MyIterator iterator = studentList.iterator();
        while (iterator.hasNext()) toSort.add((Student) iterator.next());
        toSort.sort(Comparator.comparingDouble(Student::getMathsGrade));
        toSort.forEach(sorted::append);
        return sorted;
    }

    public MyList sortMathsGradeDecreasing() {
        List<Student> toSort = ARRAY_LIST_OR_LINKED_LIST ? new ArrayList<>() : new LinkedList<>();
        MyList sorted = ARRAY_LIST_OR_LINKED_LIST ? new MyArrayList() : new MyLinkedList();
        MyIterator iterator = studentList.iterator();
        while (iterator.hasNext()) toSort.add((Student) iterator.next());
        toSort.sort(Comparator.comparingDouble(Student::getMathsGrade).reversed());
        toSort.forEach(sorted::append);
        return sorted;
    }

    public MyList sortPhysicsGradeIncreasing() {
        List<Student> toSort = ARRAY_LIST_OR_LINKED_LIST ? new ArrayList<>() : new LinkedList<>();
        MyList sorted = ARRAY_LIST_OR_LINKED_LIST ? new MyArrayList() : new MyLinkedList();
        MyIterator iterator = studentList.iterator();
        while (iterator.hasNext()) toSort.add((Student) iterator.next());
        toSort.sort(Comparator.comparingDouble(Student::getPhysicsGrade));
        toSort.forEach(sorted::append);
        return sorted;
    }

    public MyList sortPhysicsGradeDecreasing() {
        List<Student> toSort = ARRAY_LIST_OR_LINKED_LIST ? new ArrayList<>() : new LinkedList<>();
        MyList sorted = ARRAY_LIST_OR_LINKED_LIST ? new MyArrayList() : new MyLinkedList();
        MyIterator iterator = studentList.iterator();
        while (iterator.hasNext()) toSort.add((Student) iterator.next());
        toSort.sort(Comparator.comparingDouble(Student::getPhysicsGrade).reversed());
        toSort.forEach(sorted::append);
        return sorted;
    }

    public MyList sortChemistryGradeIncreasing() {
        List<Student> toSort = ARRAY_LIST_OR_LINKED_LIST ? new ArrayList<>() : new LinkedList<>();
        MyList sorted = ARRAY_LIST_OR_LINKED_LIST ? new MyArrayList() : new MyLinkedList();
        MyIterator iterator = studentList.iterator();
        while (iterator.hasNext()) toSort.add((Student) iterator.next());
        toSort.sort(Comparator.comparingDouble(Student::getChemistryGrade));
        toSort.forEach(sorted::append);
        return sorted;
    }

    public MyList sortChemistryGradeDecreasing() {
        List<Student> toSort = ARRAY_LIST_OR_LINKED_LIST ? new ArrayList<>() : new LinkedList<>();
        MyList sorted = ARRAY_LIST_OR_LINKED_LIST ? new MyArrayList() : new MyLinkedList();
        MyIterator iterator = studentList.iterator();
        while (iterator.hasNext()) toSort.add((Student) iterator.next());
        toSort.sort(Comparator.comparingDouble(Student::getChemistryGrade).reversed());
        toSort.forEach(sorted::append);
        return sorted;
    }

    public MyList sortAverageGradeIncreasing() {
        List<Student> toSort = ARRAY_LIST_OR_LINKED_LIST ? new ArrayList<>() : new LinkedList<>();
        MyList sorted = ARRAY_LIST_OR_LINKED_LIST ? new MyArrayList() : new MyLinkedList();
        MyIterator iterator = studentList.iterator();
        while (iterator.hasNext()) toSort.add((Student) iterator.next());
        toSort.sort(Comparator.comparingDouble(Student::getAverageGrade));
        toSort.forEach(sorted::append);
        return sorted;
    }

    public MyList sortAverageGradeDecreasing() {
        List<Student> toSort = ARRAY_LIST_OR_LINKED_LIST ? new ArrayList<>() : new LinkedList<>();
        MyList sorted = ARRAY_LIST_OR_LINKED_LIST ? new MyArrayList() : new MyLinkedList();
        MyIterator iterator = studentList.iterator();
        while (iterator.hasNext()) toSort.add((Student) iterator.next());
        toSort.sort(Comparator.comparingDouble(Student::getAverageGrade).reversed());
        toSort.forEach(sorted::append);
        return sorted;
    }

    public MyList filterStudentsHighestPhysicsGrade(int howMany) {
        List<Student> toFilter = ARRAY_LIST_OR_LINKED_LIST ? new ArrayList<>() : new LinkedList<>();
        MyList filtered = ARRAY_LIST_OR_LINKED_LIST ? new MyArrayList() : new MyLinkedList();
        MyList sorted = sortPhysicsGradeDecreasing();
        MyIterator iterator = sorted.iterator();
        while (iterator.hasNext()) toFilter.add((Student) iterator.next());
        toFilter = toFilter.stream().limit(howMany).collect(Collectors.toList());
        toFilter.forEach(filtered::append);
        return filtered;
    }

    public MyList filterStudentsHigherThanPhysicsGrade(double lowerBoundGrade) {
        List<Student> toFilter = ARRAY_LIST_OR_LINKED_LIST ? new ArrayList<>() : new LinkedList<>();
        MyList filtered = ARRAY_LIST_OR_LINKED_LIST ? new MyArrayList() : new MyLinkedList();
        MyList sorted = sortPhysicsGradeDecreasing();
        MyIterator iterator = sorted.iterator();
        while (iterator.hasNext()) toFilter.add((Student) iterator.next());
        toFilter = toFilter.stream().filter(student -> student.getPhysicsGrade() > lowerBoundGrade)
                .collect(Collectors.toList());
        toFilter.forEach(filtered::append);
        return filtered;
    }

    public MyList filterStudentsLowestPhysicsGrade(int howMany) {
        List<Student> toFilter = ARRAY_LIST_OR_LINKED_LIST ? new ArrayList<>() : new LinkedList<>();
        MyList filtered = ARRAY_LIST_OR_LINKED_LIST ? new MyArrayList() : new MyLinkedList();
        MyList sorted = sortPhysicsGradeIncreasing();
        MyIterator iterator = sorted.iterator();
        while (iterator.hasNext()) toFilter.add((Student) iterator.next());
        toFilter = toFilter.stream().limit(howMany).collect(Collectors.toList());
        toFilter.forEach(filtered::append);
        return filtered;
    }

    public MyList filterStudentsLowerThanPhysicsGrade(double upperBoundGrade) {
        List<Student> toFilter = ARRAY_LIST_OR_LINKED_LIST ? new ArrayList<>() : new LinkedList<>();
        MyList filtered = ARRAY_LIST_OR_LINKED_LIST ? new MyArrayList() : new MyLinkedList();
        MyList sorted = sortPhysicsGradeDecreasing();
        MyIterator iterator = sorted.iterator();
        while (iterator.hasNext()) toFilter.add((Student) iterator.next());
        toFilter = toFilter.stream().filter(student -> student.getPhysicsGrade() < upperBoundGrade)
                .collect(Collectors.toList());
        toFilter.forEach(filtered::append);
        return filtered;
    }

    public MyList filterStudentsHighestMathsGrade(int howMany) {
        List<Student> toFilter = ARRAY_LIST_OR_LINKED_LIST ? new ArrayList<>() : new LinkedList<>();
        MyList filtered = ARRAY_LIST_OR_LINKED_LIST ? new MyArrayList() : new MyLinkedList();
        MyList sorted = sortMathsGradeDecreasing();
        MyIterator iterator = sorted.iterator();
        while (iterator.hasNext()) toFilter.add((Student) iterator.next());
        toFilter = toFilter.stream().limit(howMany).collect(Collectors.toList());
        toFilter.forEach(filtered::append);
        return filtered;
    }

    public MyList filterStudentsHigherThanMathsGrade(double lowerBoundGrade) {
        List<Student> toFilter = ARRAY_LIST_OR_LINKED_LIST ? new ArrayList<>() : new LinkedList<>();
        MyList filtered = ARRAY_LIST_OR_LINKED_LIST ? new MyArrayList() : new MyLinkedList();
        MyList sorted = sortMathsGradeDecreasing();
        MyIterator iterator = sorted.iterator();
        while (iterator.hasNext()) toFilter.add((Student) iterator.next());
        toFilter = toFilter.stream().filter(student -> student.getMathsGrade() > lowerBoundGrade)
                .collect(Collectors.toList());
        toFilter.forEach(filtered::append);
        return filtered;
    }

    public MyList filterStudentsLowestMathsGrade(int howMany) {
        List<Student> toFilter = ARRAY_LIST_OR_LINKED_LIST ? new ArrayList<>() : new LinkedList<>();
        MyList filtered = ARRAY_LIST_OR_LINKED_LIST ? new MyArrayList() : new MyLinkedList();
        MyList sorted = sortMathsGradeIncreasing();
        MyIterator iterator = sorted.iterator();
        while (iterator.hasNext()) toFilter.add((Student) iterator.next());
        toFilter = toFilter.stream().limit(howMany).collect(Collectors.toList());
        toFilter.forEach(filtered::append);
        return filtered;
    }

    public MyList filterStudentsLowerThanMathsGrade(double upperBoundGrade) {
        List<Student> toFilter = ARRAY_LIST_OR_LINKED_LIST ? new ArrayList<>() : new LinkedList<>();
        MyList filtered = ARRAY_LIST_OR_LINKED_LIST ? new MyArrayList() : new MyLinkedList();
        MyList sorted = sortMathsGradeDecreasing();
        MyIterator iterator = sorted.iterator();
        while (iterator.hasNext()) toFilter.add((Student) iterator.next());
        toFilter = toFilter.stream().filter(student -> student.getMathsGrade() < upperBoundGrade)
                .collect(Collectors.toList());
        toFilter.forEach(filtered::append);
        return filtered;
    }

    public MyList filterStudentsHighestChemistryGrade(int howMany) {
        List<Student> toFilter = ARRAY_LIST_OR_LINKED_LIST ? new ArrayList<>() : new LinkedList<>();
        MyList filtered = ARRAY_LIST_OR_LINKED_LIST ? new MyArrayList() : new MyLinkedList();
        MyList sorted = sortChemistryGradeDecreasing();
        MyIterator iterator = sorted.iterator();
        while (iterator.hasNext()) toFilter.add((Student) iterator.next());
        toFilter = toFilter.stream().limit(howMany).collect(Collectors.toList());
        toFilter.forEach(filtered::append);
        return filtered;
    }

    public MyList filterStudentsHigherThanChemistryGrade(double lowerBoundGrade) {
        List<Student> toFilter = ARRAY_LIST_OR_LINKED_LIST ? new ArrayList<>() : new LinkedList<>();
        MyList filtered = ARRAY_LIST_OR_LINKED_LIST ? new MyArrayList() : new MyLinkedList();
        MyList sorted = sortChemistryGradeDecreasing();
        MyIterator iterator = sorted.iterator();
        while (iterator.hasNext()) toFilter.add((Student) iterator.next());
        toFilter = toFilter.stream().filter(student -> student.getChemistryGrade() > lowerBoundGrade)
                .collect(Collectors.toList());
        toFilter.forEach(filtered::append);
        return filtered;
    }

    public MyList filterStudentsLowestChemistryGrade(int howMany) {
        List<Student> toFilter = ARRAY_LIST_OR_LINKED_LIST ? new ArrayList<>() : new LinkedList<>();
        MyList filtered = ARRAY_LIST_OR_LINKED_LIST ? new MyArrayList() : new MyLinkedList();
        MyList sorted = sortChemistryGradeIncreasing();
        MyIterator iterator = sorted.iterator();
        while (iterator.hasNext()) toFilter.add((Student) iterator.next());
        toFilter = toFilter.stream().limit(howMany).collect(Collectors.toList());
        toFilter.forEach(filtered::append);
        return filtered;
    }

    public MyList filterStudentsLowerThanChemistryGrade(double upperBoundGrade) {
        List<Student> toFilter = ARRAY_LIST_OR_LINKED_LIST ? new ArrayList<>() : new LinkedList<>();
        MyList filtered = ARRAY_LIST_OR_LINKED_LIST ? new MyArrayList() : new MyLinkedList();
        MyList sorted = sortChemistryGradeDecreasing();
        MyIterator iterator = sorted.iterator();
        while (iterator.hasNext()) toFilter.add((Student) iterator.next());
        toFilter = toFilter.stream().filter(student -> student.getChemistryGrade() < upperBoundGrade)
                .collect(Collectors.toList());
        toFilter.forEach(filtered::append);
        return filtered;
    }

    public MyList filterStudentsHighestAverageGrade(int howMany) {
        List<Student> toFilter = ARRAY_LIST_OR_LINKED_LIST ? new ArrayList<>() : new LinkedList<>();
        MyList filtered = ARRAY_LIST_OR_LINKED_LIST ? new MyArrayList() : new MyLinkedList();
        MyList sorted = sortAverageGradeDecreasing();
        MyIterator iterator = sorted.iterator();
        while (iterator.hasNext()) toFilter.add((Student) iterator.next());
        toFilter = toFilter.stream().limit(howMany).collect(Collectors.toList());
        toFilter.forEach(filtered::append);
        return filtered;
    }

    public MyList filterStudentsHigherThanAverageGrade(double lowerBoundGrade) {
        List<Student> toFilter = ARRAY_LIST_OR_LINKED_LIST ? new ArrayList<>() : new LinkedList<>();
        MyList filtered = ARRAY_LIST_OR_LINKED_LIST ? new MyArrayList() : new MyLinkedList();
        MyList sorted = sortAverageGradeDecreasing();
        MyIterator iterator = sorted.iterator();
        while (iterator.hasNext()) toFilter.add((Student) iterator.next());
        toFilter = toFilter.stream().filter(student -> student.getAverageGrade() > lowerBoundGrade)
                .collect(Collectors.toList());
        toFilter.forEach(filtered::append);
        return filtered;
    }

    public MyList filterStudentsLowestAverageGrade(int howMany) {
        List<Student> toFilter = ARRAY_LIST_OR_LINKED_LIST ? new ArrayList<>() : new LinkedList<>();
        MyList filtered = ARRAY_LIST_OR_LINKED_LIST ? new MyArrayList() : new MyLinkedList();
        MyList sorted = sortAverageGradeIncreasing();
        MyIterator iterator = sorted.iterator();
        while (iterator.hasNext()) toFilter.add((Student) iterator.next());
        toFilter = toFilter.stream().limit(howMany).collect(Collectors.toList());
        toFilter.forEach(filtered::append);
        return filtered;
    }


    public static String idOfStudentsToString(MyList studentList) {
        StringBuilder idOfStudents = new StringBuilder();
        idOfStudents.append("[");
        MyIterator iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Student student = (Student) iterator.next();
            idOfStudents.append(student.getId()).append(" ");
        }
        return idOfStudents.toString().trim() + "]";
    }

    public static void print(MyList studentList) {
        StringBuilder studentsString = new StringBuilder();
        studentsString.append("[\n");
        MyIterator iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Student student = (Student) iterator.next();
            studentsString.append(student.toString()).append("\n");
        }
        System.out.print(studentsString.toString().trim() + "\n]");
    }

}