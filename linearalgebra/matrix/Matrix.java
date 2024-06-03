package yukwork.linearalgebra.matrix;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Matrix {

    private final int rows;
    private final int cols;
    private double[][] data;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        data = new double[rows][cols];
    }

    public Matrix(int rows, int cols, int lowerBoundRandom, int upperBoundRandom) {
        this.rows = rows;
        this.cols = cols;
        initRandom(rows, cols, lowerBoundRandom, upperBoundRandom);
    }

    private void initRandom(int rows, int cols, int lowerBound, int upperBound) {
        Random random = new Random();
        data = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = random.nextInt(upperBound - lowerBound) + lowerBound;
            }
        }
    }

    private void checkValidIndex(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols)
            throw new IllegalArgumentException("Invalid row or column index!");
    }

    private void checkSameSizeMatrix(Matrix another) {
        if (rows != another.rows || cols != another.cols)
            throw new IllegalArgumentException("Matrices are not the same size!");
    }

    private void checkSquareMatrix() {
        if (rows != cols) throw new IllegalArgumentException("Not a square first.matrix!");
    }

    public Matrix gaussianElimination() {
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            System.arraycopy(data[i], 0, result.data[i], 0, cols);
        }

        int minDim = Math.min(rows, cols);
        for (int i = 0; i < minDim; i++) {
            int pivotRow = i;
            for (int j = i + 1; j < rows; j++) {
                if (Math.abs(result.data[j][i]) > Math.abs(result.data[pivotRow][i])) {
                    pivotRow = j;
                }
            }
            result.swapRows(i, pivotRow);

            if (Math.abs(result.data[i][i]) < 1e-10) {
                continue;
            }

            for (int j = i + 1; j < rows; j++) {
                double factor = result.data[j][i] / result.data[i][i];
                for (int k = i; k < cols; k++) {
                    result.data[j][k] -= factor * result.data[i][k];
                }
                result.data[j][i] = 0;
            }
        }

        return result;
    }

    public Matrix gaussJordanElimination() {
        Matrix result = this.gaussianElimination();

        int minDim = Math.min(rows, cols);
        for (int i = minDim - 1; i >= 0; i--) {
            if (Math.abs(result.data[i][i]) < 1e-10) {
                continue;
            }

            result = result.scaledRow(i, 1 / result.data[i][i]);

            for (int j = 0; j < i; j++) {
                double factor = result.data[j][i];
                result.addRow(-factor, i, j);
            }
        }

        return result;
    }

    public double determinant() {
        checkSquareMatrix();
        if (rows == 1) {
            return data[0][0];
        } else if (rows == 2) {
            return data[0][0] * data[1][1] - data[0][1] * data[1][0];
        } else {
            double det = 0;
            for (int j = 0; j < cols; j++) {
                det += Math.pow(-1, j) * data[0][j] * subMatrix(j).determinant();
            }
            return det;
        }
    }

    private Matrix subMatrix(int excludingCol) {
        Matrix sub = new Matrix(rows - 1, cols - 1);
        int rowIndex = 0;
        for (int i = 0; i < rows; i++) {
            if (i == 0) {
                continue;
            }
            int colIndex = 0;
            for (int j = 0; j < cols; j++) {
                if (j == excludingCol) {
                    continue;
                }
                sub.data[rowIndex][colIndex] = data[i][j];
                colIndex++;
            }
            rowIndex++;
        }
        return sub;
    }

    public Map<Character, Double> solveFor(double[]... constants) {
        if (constants.length != rows || constants[0].length != 1 || constants.length > 26) {
            throw new IllegalArgumentException("Invalid constant vector(s) provided.");
        }

        Matrix augmentedMatrix = new Matrix(rows, cols + constants[0].length);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                augmentedMatrix.set(i, j, data[i][j]);
            }
        }
        for (int i = 0; i < rows; i++) {
            augmentedMatrix.set(i, cols, constants[i][0]);
        }

        Matrix solvedMatrix = augmentedMatrix.gaussJordanElimination();

        Map<Character, Double> solutions = new HashMap<>();

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);

        for (int i = 0; i < cols; i++) {
            double roundedValue = Double.parseDouble(decimalFormat.format(solvedMatrix.get(i, cols)));
            solutions.put((char) ('a' + i), roundedValue);
        }

        return solutions;
    }

    public void set(int row, int col, double value) {
        checkValidIndex(row, col);
        data[row][col] = value;
    }

    public double get(int row, int col) {
        checkValidIndex(row, col);
        return data[row][col];
    }

    public Matrix getSortedMatrix() {
        double[] sortedArray = Arrays.stream(data)
                .flatMapToDouble(Arrays::stream)
                .sorted()
                .toArray();

        Matrix sortedMatrix = new Matrix(rows, cols);
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sortedMatrix.data[i][j] = sortedArray[index++];
            }
        }
        return sortedMatrix;
    }

    public Matrix add(Matrix another) {
        checkSameSizeMatrix(another);
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = data[i][j] + another.data[i][j];
            }
        }
        return result;
    }

    public Matrix minus(Matrix another) {
        checkSameSizeMatrix(another);
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = data[i][j] - another.data[i][j];
            }
        }
        return result;
    }

    public Matrix multiply(Matrix another) {
        if (rows != another.cols)
            throw new IllegalArgumentException("Number of columns of first first.matrix should be equal to number of rows in second first.matrix");
        Matrix result = new Matrix(rows, another.cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < another.cols; j++) {
                for (int k = 0; k < cols; k++) {
                    result.data[i][j] += data[i][k] * another.data[k][j];
                }
            }
        }
        return result;
    }

    public void addColumn(double scalar, int from, int to) {
        checkValidIndex(0, from);
        checkValidIndex(0, to);
        for (int i = 0; i < rows; i++) {
            data[i][to] += scalar * data[i][from];
        }
    }

    public void addRow(double scalar, int from, int to) {
        checkValidIndex(from, 0);
        checkValidIndex(to, 0);
        for (int j = 0; j < cols; j++) {
            data[to][j] += scalar * data[from][j];
        }
    }

    public Matrix scaled(double scalar) {
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = data[i][j] * scalar;
            }
        }
        return result;
    }

    public Matrix scaledColumn(int col, double scalar) {
        checkValidIndex(0, col);
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            if (cols >= 0) System.arraycopy(data[i], 0, result.data[i], 0, cols);
        }
        for (int i = 0; i < rows; i++) {
            result.data[i][col] *= scalar;
        }
        return result;
    }

    public Matrix scaledRow(int row, double scalar) {
        checkValidIndex(row, 0);
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            if (cols >= 0) System.arraycopy(data[i], 0, result.data[i], 0, cols);
        }
        for (int j = 0; j < cols; j++) {
            result.data[row][j] *= scalar;
        }
        return result;
    }

    public void swapColumns(int from, int to) {
        checkValidIndex(0, from);
        checkValidIndex(0, to);
        for (int i = 0; i < rows; i++) {
            double temp = data[i][from];
            data[i][from] = data[i][to];
            data[i][to] = temp;
        }
    }

    public void swapRows(int from, int to) {
        checkValidIndex(from, 0);
        checkValidIndex(to, 0);
        double[] temp = data[from];
        data[from] = data[to];
        data[to] = temp;
    }

    public Matrix tranpose() {
        Matrix tranposed = new Matrix(cols, rows);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                tranposed.data[j][i] = data[i][j];
            }
        }
        return tranposed;
    }

    public double[] principalDiagonal() {
        checkSquareMatrix();
        double[] diagonal = new double[rows];
        for (int i = 0; i < rows; i++) {
            diagonal[i] = data[i][i];
        }
        return diagonal;
    }

    public double[] secondaryDiagonal() {
        checkSquareMatrix();
        double[] diagonal = new double[rows];
        for (int i = 0; i < rows; i++) {
            diagonal[i] = data[i][cols - i - 1];
        }
        return diagonal;
    }

    @Override
    public String toString() {
        StringBuilder matrix = new StringBuilder();
        String format = "%.1f";
        int[] columnWidths = new int[cols];

        for (int j = 0; j < cols; j++) {
            int maxWidth = 0;
            for (double[] dataRow : data) {
                double value = dataRow[j];
                if (Math.abs(value) < 0.001) {
                    value = Math.abs(value);
                }
                String formattedNumber = String.format(format, value);
                if (formattedNumber.length() > maxWidth) {
                    maxWidth = formattedNumber.length();
                }
            }
            columnWidths[j] = maxWidth;
        }

        StringBuilder horizontalBorder = new StringBuilder("+");
        for (int j = 0; j < cols; j++) {
            horizontalBorder.append("-".repeat(columnWidths[j] + 2)).append("+");
        }
        horizontalBorder.append("\n");
        matrix.append(horizontalBorder);

        for (double[] dataRow : data) {
            matrix.append("|");
            for (int j = 0; j < cols; j++) {
                double value = dataRow[j];
                if (Math.abs(value) < 0.001) {
                    value = Math.abs(value);
                }
                String formattedNumber = String.format(format, value);
                matrix.append(String.format(" %" + columnWidths[j] + "s |", formattedNumber));
            }
            matrix.append("\n");
            matrix.append(horizontalBorder);
        }

        return matrix.toString();
    }

}
