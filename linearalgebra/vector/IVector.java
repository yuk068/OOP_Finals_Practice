package yukwork.linearalgebra.vector;

public interface IVector {

    void append(double value);

    double element(int index);

    double[] elements();

    void insert(int index, double value);

    int length();

    double magnitude();

    void remove(int index);

}
