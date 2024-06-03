package yukwork.statistics.samplemanager.candidatemanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    private static final String COMMA_DELIMITER = ",";

    public static void main(String[] args) {
        init();
        testOriginalData();

        System.out.println("\n** Test Sorts**");
        testSortYearOfBirthIncreasing();
        System.out.println("  - Sorted by Year of Birth (Increasing)");
        testSortYearOfBirthDecreasing();
        System.out.println("  - Sorted by Year of Birth (Decreasing)");
        testSortAverageGradeIncreasing();
        System.out.println("  - Sorted by Average Grade (Increasing)");
        testSortAverageGradeDecreasing();
        System.out.println("  - Sorted by Average Grade (Decreasing)");

        System.out.println("\n** Test Filters (Top 5)**");
        testFilterStudentsHighestMathsGrade();
        System.out.println("  - Top 5 Students with Highest Maths Grade");
        testFilterStudentsLowestMathsGrade();
        System.out.println("  - Top 5 Students with Lowest Maths Grade");
        testFilterStudentsHighestAverageGrade();
        System.out.println("  - Top 5 Students with Highest Average Grade");
        testFilterStudentsLowestAverageGrade();
        System.out.println("  - Top 5 Students with Lowest Average Grade");

        System.out.println("\n** Test Filters (Bound)**");
        testFilterStudentsHigherThanAverageGrade();
        System.out.println("  - Students with Average Grade Higher Than 8");
        testFilterStudentsLowerThanChemistryGrade();
        System.out.println("  - Students with Chemistry Grade Lower Than 3");
    }



    public static void init() {
        String filePath = "C:\\Users\\Phong Vu\\IdeaProjects\\OOPFinalsPractce\\src\\yukwork\\statistics\\samplemanager\\data\\students.csv";
        readListData(filePath);
    }

    public static void readListData(String filePath) {
        BufferedReader dataReader;
        try {
            String line;
            dataReader = new BufferedReader(new FileReader(filePath));

            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);
                if (dataList.size() != 7) {
                    continue;
                }
                if (dataList.get(0).equals("id")) {
                    continue;
                }
                Student.StudentBuilder builder = new Student.StudentBuilder(dataList.get(0)).
                        withLastName(dataList.get(1)).withFirstName(dataList.get(2)).
                        withYearOfBirth(Integer.parseInt(dataList.get(3))).
                        withMathsGrade(Double.parseDouble(dataList.get(4))).
                        withPhysicsGrade(Double.parseDouble(dataList.get(5))).
                        withChemistryGrade(Double.parseDouble(dataList.get(6)));
                StudentManager.getInstance().append(builder.build());
            }
        } catch (IOException e) {
            System.out.println("Something went wrong reading data from file");
        }
    }

    public static List<String> parseDataLineToList(String dataLine) {
        List<String> result = new ArrayList<>();
        if (dataLine != null) {
            String[] splitData = dataLine.split(COMMA_DELIMITER);
            result.addAll(Arrays.asList(splitData));
        }
        return result;
    }

    public static String[] parseDataLineToArray(String dataLine) {
        if (dataLine == null) {
            return null;
        }
        return dataLine.split(COMMA_DELIMITER);
    }

    public static void testOriginalData() {
        System.out.println(StudentManager.idOfStudentsToString(StudentManager.getInstance().getStudentList()));
    }

    public static void testSortYearOfBirthIncreasing() {
        StudentManager.print(StudentManager.getInstance().sortYearOfBirthIncreasing());
    }

    public static void testSortYearOfBirthDecreasing() {
        StudentManager.print(StudentManager.getInstance().sortYearOfBirthDecreasing());
    }

    public static void testSortAverageGradeIncreasing() {
        StudentManager.print(StudentManager.getInstance().sortAverageGradeIncreasing());
    }

    public static void testSortAverageGradeDecreasing() {
        StudentManager.print(StudentManager.getInstance().sortAverageGradeDecreasing());
    }

    public static void testFilterStudentsHighestMathsGrade() {
        StudentManager.print(StudentManager.getInstance().filterStudentsHighestMathsGrade(5));
    }

    public static void testFilterStudentsLowestMathsGrade() {
        StudentManager.print(StudentManager.getInstance().filterStudentsLowestMathsGrade(5));
    }

    public static void testFilterStudentsHighestAverageGrade() {
        StudentManager.print(StudentManager.getInstance().filterStudentsHighestAverageGrade(5));
    }

    public static void testFilterStudentsLowestAverageGrade() {
        StudentManager.print(StudentManager.getInstance().filterStudentsLowestAverageGrade(5));
    }

    public static void testFilterStudentsHigherThanAverageGrade() {
        StudentManager.print(StudentManager.getInstance().filterStudentsHigherThanAverageGrade(8));
    }

    public static void testFilterStudentsLowerThanChemistryGrade() {
        StudentManager.print(StudentManager.getInstance().filterStudentsLowerThanChemistryGrade(3));
    }

}
