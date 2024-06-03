package yukwork.statistics.datastatistics;

public interface Statistic {

    double max();
    double mean();
    double median();
    double min();
    double[] rank();
    int size();
    double variance();

}
