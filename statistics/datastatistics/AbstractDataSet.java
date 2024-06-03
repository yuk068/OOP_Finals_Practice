package yukwork.statistics.datastatistics;

public abstract class AbstractDataSet implements DataSet {

    public void checkBound(int index, int limit) {
        if (index < 0 || index > limit) {
            throw new IndexOutOfBoundsException("Index: " + index + " for size: " + size());
        }
    }

    @Override
    public String toString() {
        StringBuilder dataSetString = new StringBuilder("[");

        for (int i = 0; i < this.size(); i++) {
            if (i == this.size() - 1) {
                dataSetString.append(this.element(i)).append("]");
            } else {
                dataSetString.append(this.element(i)).append(", ");
            }
        }

        return dataSetString.toString();
    }

}
