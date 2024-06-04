package yukwork.statistics.datastatistics;

public interface DataSet {

    void append(double value);

    double element(int index);

    double[] elements(int begin, int end);

    void insert(double value, int index);

    void remove(double value);

    void remove(int index);

    int size();

}
