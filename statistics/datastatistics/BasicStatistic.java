package yukwork.statistics.datastatistics;

import java.util.*;

public class BasicStatistic implements Statistic {

    private DataSet dataSet;

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
    public double range() {
        return max() - min();
    }

    @Override
    public double standardDeviation() {
        return Math.sqrt(variance());
    }

    @Override
    public double percentile(double percentage) {
        double[] sorted = dataSet.elements(0, size() - 1);
        Arrays.sort(sorted);
        int index = (int) Math.ceil(percentage / 100.0 * size()) - 1;
        return sorted[index];
    }

    @Override
    public double[] quartiles() {
        double[] quartiles = new double[3];
        double[] sorted = dataSet.elements(0, size() - 1);
        Arrays.sort(sorted);
        int q1Index = (int) Math.ceil(0.25 * size()) - 1;
        int q2Index = (int) Math.ceil(0.5 * size()) - 1;
        int q3Index = (int) Math.ceil(0.75 * size()) - 1;
        quartiles[0] = sorted[q1Index];
        quartiles[1] = sorted[q2Index];
        quartiles[2] = sorted[q3Index];
        return quartiles;
    }

    @Override
    public double interquartileRange() {
        double[] quartiles = quartiles();
        return quartiles[2] - quartiles[0];
    }

    @Override
    public double skewness() {
        double skewness = 0.0;
        double mean = mean();
        double variance = variance();
        for (int i = 0; i < size(); i++) {
            skewness += Math.pow((dataSet.element(i) - mean) / Math.sqrt(variance), 3);
        }
        return skewness / size();
    }

    @Override
    public double kurtosis() {
        double kurtosis = 0.0;
        double mean = mean();
        double variance = variance();
        for (int i = 0; i < size(); i++) {
            kurtosis += Math.pow((dataSet.element(i) - mean) / Math.sqrt(variance), 4);
        }
        return kurtosis / size();
    }

    @Override
    public double sum() {
        double sum = 0.0;
        for (int i = 0; i < size(); i++) {
            sum += dataSet.element(i);
        }
        return sum;
    }

    @Override
    public double product() {
        double product = 1.0;
        for (int i = 0; i < size(); i++) {
            product *= dataSet.element(i);
        }
        return product;
    }

    @Override
    public int count() {
        return size();
    }

    @Override
    public Map<Double, Integer> frequencyDistribution() {
        Map<Double, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < size(); i++) {
            double value = dataSet.element(i);
            frequencyMap.put(value, frequencyMap.getOrDefault(value, 0) + 1);
        }
        return frequencyMap;
    }

    @Override
    public Map<Double, Integer> cumulativeFrequencyDistribution() {
        Map<Double, Integer> frequencyMap = frequencyDistribution();
        Map<Double, Integer> cumulativeFrequencyMap = new TreeMap<>();
        int cumulativeFrequency = 0;
        for (Map.Entry<Double, Integer> entry : frequencyMap.entrySet()) {
            cumulativeFrequency += entry.getValue();
            cumulativeFrequencyMap.put(entry.getKey(), cumulativeFrequency);
        }
        return cumulativeFrequencyMap;
    }

    @Override
    public int size() {
        return dataSet.size();
    }

}
