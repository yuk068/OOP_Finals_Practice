package yukwork.statistics.datastatistics;

public class ArrayDataSet extends AbstractDataSet {

    private static final int DEFAULT_CAPACITY = 16;
    private double[] data;
    private int size;

    public ArrayDataSet() {
        data = new double[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void append(double value) {
        if (size >= data.length) {
            enlarge();
        }
        data[size++] = value;
    }

    @Override
    public double element(int index) {
        checkBound(index, size - 1);
        return data[index];
    }

    @Override
    public double[] elements(int begin, int end) {
        checkBound(begin, size - 1);
        checkBound(end, size - 1);

        if (begin > end) throw new IllegalArgumentException("Begin cannot be greater than end");

        int length = end - begin + 1;
        double[] result = new double[length];
        System.arraycopy(data, begin, result, 0, length);
        return result;
    }

    @Override
    public void insert(double value, int index) {
        checkBound(index, size);
        if (size >= data.length) {
            enlarge();
        }
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = value;
        size++;
    }

    @Override
    public void remove(double value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                System.arraycopy(data, i + 1, data, i, size - i);
                size--;
                i--;
            }
        }
    }

    @Override
    public void remove(int index) {
        checkBound(index, size - 1);
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    private void enlarge() {
        double[] enlargedData = new double[data.length * 2];
        System.arraycopy(data, 0, enlargedData, 0, size);
        data = enlargedData;
    }

}
