package yukwork.statistics.datastatistics;

import java.util.*;

public class BasicStatistic implements Statistic {

    DataSet dataSet;

    public void setDataSet(DataSet dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public double max() {
        return Arrays.stream(dataSet.elements(0, size() - 1))
                .max()
                .orElse(Double.NaN);
    }

    @Override
    public double mean() {
        return Arrays.stream(dataSet.elements(0, size() - 1))
                .average()
                .orElse(Double.NaN);
    }

    @Override
    public double median() {
        double[] dummy = Arrays.stream(dataSet.elements(0, size() - 1)).toArray();
        Arrays.sort(dummy);

        int length = dummy.length;
        if (length % 2 == 0) {
            return (dummy[length/2 - 1] + dummy[length/2]) / 2.0;
        } else {
            return dummy[length/2];
        }
    }

    @Override
    public double min() {
        return Arrays.stream(dataSet.elements(0, dataSet.size() - 1))
                .min()
                .orElse(Double.NaN);
    }

    @Override
    public double[] rank() {
        List<Double> rankArray = new ArrayList<>();
        double[] sorted = dataSet.elements(0, size() - 1);
        Arrays.sort(sorted);
        Set<Double> seen = new HashSet<>();

        for (int i = 0; i < size(); i++) {
            double rank;
            int occurrence;
            if (!seen.contains(dataSet.element(i))) {
                rank = 0;
                int j;
                for (j = 0; j < size(); j++) {
                    if (sorted[j] == dataSet.element(i)) {
                        rank = j + 1;
                        seen.add(sorted[j]);
                        break;
                    }
                }
                occurrence = 1;
                for (int k = j + 1; k < size(); k++) {
                    if (sorted[j] == sorted[k]) {
                        rank += rank + 1;
                        occurrence++;
                    } else {
                        break;
                    }
                }
                rankArray.add(rank / occurrence);
            }
        }
        return rankArray.stream()
                .mapToDouble(Double::doubleValue)
                .toArray();
    }

    @Override
    public double variance() {
        double var = 0.0;
        double mean = mean();

        for (int i = 0; i < size(); i++) {
            var += (dataSet.element(i) - mean) * (dataSet.element(i) - mean);
        }

        return var / size();
    }

    @Override
    public int size() {
        return dataSet.size();
    }

}
