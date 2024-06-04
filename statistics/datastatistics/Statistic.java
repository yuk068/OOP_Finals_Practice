package yukwork.statistics.datastatistics;

import java.util.Map;

public interface Statistic {

    double max();

    double mean();

    double median();

    double min();

    double[] rank();

    double range();

    double standardDeviation();

    double percentile(double percentage);

    double[] quartiles();

    double interquartileRange();

    double skewness();

    double kurtosis();

    double sum();

    double product();

    int count();

    Map<Double, Integer> frequencyDistribution();

    Map<Double, Integer> cumulativeFrequencyDistribution();

    int size();

    double variance();

}
