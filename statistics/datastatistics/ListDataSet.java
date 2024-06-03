package yukwork.statistics.datastatistics;

import java.util.ArrayList;
import java.util.List;

public class ListDataSet extends AbstractDataSet {

    List<Double> data;

    public ListDataSet() {
        data = new ArrayList<>();
    }

    @Override
    public void append(double value) {
        data.add(value);
    }

    @Override
    public double element(int index) {
        checkBound(index, data.size());
        return data.get(index);
    }

    @Override
    public double[] elements(int begin, int end) {
        checkBound(begin, data.size() - 1);
        checkBound(end, data.size() - 1);

        if (begin > end) throw new IllegalArgumentException("Begin cannot be greater than end");

        return data.subList(begin, end + 1).stream()
                .mapToDouble(Double::doubleValue)
                .toArray();
    }

    @Override
    public void insert(double value, int index) {
        checkBound(index, data.size());
        data.add(index, value);
    }

    @Override
    public void remove(double value) {
        data.removeIf(element -> element == value);
    }

    @Override
    public void remove(int index) {
        checkBound(index, data.size() - 1);
        data.remove(index);
    }

    @Override
    public int size() {
        return data.size();
    }

}
