package yukwork.statistics.datastatistics;

import java.util.Arrays;

public class TestStatistics {

    public static void main(String[] args) {
        BasicStatistic operator = new BasicStatistic();
        DataSet dataSet = new ArrayDataSet();

        for (int i = 10; i > 0; i--) {
            dataSet.append(i * i);
        }

        operator.setDataSet(dataSet);
        System.out.println("Max: " + operator.max());
        System.out.println("Min: " + operator.min());
        System.out.println("Mean: " + operator.mean());
        System.out.println("Median: " + operator.median());
        System.out.println("Variance: " + operator.variance());
        System.out.println("Range: " + operator.range());
        System.out.println("Standard Deviation: " + operator.standardDeviation());
        System.out.println("Percentile (25%): " + operator.percentile(25));
        System.out.println("Percentile (75%): " + operator.percentile(75));

        DataSet rankTest = new ListDataSet();

        rankTest.append(3);
        rankTest.append(3);
        rankTest.append(5);
        rankTest.append(3);
        rankTest.append(3);
        rankTest.append(1);
        rankTest.append(1);

        operator.setDataSet(rankTest);
        System.out.println("Rank: " + Arrays.toString(operator.rank()));
        System.out.println("Quartiles: " + Arrays.toString(operator.quartiles()));
        System.out.println("Interquartile Range: " + operator.interquartileRange());
        System.out.println("Skewness: " + operator.skewness());
        System.out.println("Kurtosis: " + operator.kurtosis());
        System.out.println("Sum: " + operator.sum());
        System.out.println("Product: " + operator.product());
        System.out.println("Count: " + operator.count());
        System.out.println("Frequency Distribution: " + operator.frequencyDistribution());
        System.out.println("Cumulative Frequency Distribution: " + operator.cumulativeFrequencyDistribution());
    }

}
