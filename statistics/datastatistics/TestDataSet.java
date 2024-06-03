package yukwork.statistics.datastatistics;

import java.util.Arrays;

public class TestDataSet {

    public static void main(String[] args) {
//        DataSet array = new ListDataSet();
        DataSet array = new ArrayDataSet();
        for (int i = 1; i <= 11; i++) {
            array.append(i*i);
        }
        array.insert(5.5, 3);
        for (int i = 1; i <= 11; i++) {
            array.insert(-i, 3);
        }
        array.remove(25.0);
        System.out.println(array);
        System.out.println(array.size() + "AAAAAAAAAAA");

//        DataSet dupes = new ListDataSet();
        DataSet dupes = new ArrayDataSet();
        for (int i = 0; i < 5; i++) {
            dupes.append(68.0);
        }
        System.out.println(dupes.size());
        dupes.insert(1.0, 0);
        dupes.insert(2.0, 2);
        dupes.insert(3.0, 4);
        dupes.remove(68.0);
        System.out.println(dupes);
        System.out.println(dupes.size());

        System.out.println(Arrays.toString(array.elements(5, 21)));

        DataSet test = new ArrayDataSet();
        for (int i = 0; i < 5; i++) {
            test.append(i + 1);
        }
        test.insert(45.0, 4);
        System.out.println(test);
//        int[] testCopy = new int[10];
//        for (int i = 1; i < 7; i++) {
//            testCopy[i] = i + 1;
//        }
//        System.arraycopy(testCopy, 2, testCopy, 1, 5);
//        System.out.println(Arrays.toString(testCopy));
    }

}
