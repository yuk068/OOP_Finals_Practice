package yukwork.statistics.datastatistics;

import java.util.Arrays;

public class TestStatistics {

    public TestStatistics() {
    }

    public static void main(String[] args) {
        BasicStatistic operator = new BasicStatistic();
        DataSet dataSet = new ArrayDataSet();

        for (int i = 10; i > 0; i--) {
            dataSet.append(i*i);
        }

//        AbstractDataSet.print(dataSet);
//        System.out.println(dataSet.size() + "\n");

        operator.setDataSet(dataSet);
        System.out.println(operator.max());
        System.out.println(operator.min());
        System.out.println(operator.mean());
        System.out.println(operator.median());
        System.out.println(operator.variance());

        DataSet rankTest = new ListDataSet();

        rankTest.append(3);
        rankTest.append(3);
        rankTest.append(5);
        rankTest.append(3);
        rankTest.append(3);
        rankTest.append(1);
        rankTest.append(1);

        operator.setDataSet(rankTest);
        System.out.println(Arrays.toString(operator.rank()));
    }

}
