package yukwork.linearalgebra.matrix;

import java.util.Map;

public class MatrixTest {

    public static void main(String[] args) {
        testCreation();
        testRandomInitialization();
        testDeterminant();
        testGaussianElimination();
        testGaussJordanElimination();
        testSolveFor();
        testAddition();
        testSubtraction();
        testMultiplication();
        testTranspose();
        testPrincipalDiagonal();
        testSecondaryDiagonal();
    }

    private static void testCreation() {
        Matrix matrix = new Matrix(3, 3);
        System.out.println("Created matrix:");
        System.out.println(matrix);
    }

    private static void testRandomInitialization() {
        Matrix matrix = new Matrix(3, 3, 0, 10);
        System.out.println("Randomly initialized matrix:");
        System.out.println(matrix);
    }

    private static void testDeterminant() {
        Matrix matrix = new Matrix(3, 3);
        matrix.set(0, 0, 1);
        matrix.set(0, 1, 2);
        matrix.set(0, 2, 3);
        matrix.set(1, 0, 4);
        matrix.set(1, 1, 5);
        matrix.set(1, 2, 6);
        matrix.set(2, 0, 7);
        matrix.set(2, 1, 8);
        matrix.set(2, 2, 9);
        System.out.println(matrix);
        double determinant = matrix.determinant();
        System.out.println("Determinant of the matrix: " + determinant);
    }

    private static void testGaussianElimination() {
        Matrix matrix = new Matrix(3, 3);
        matrix.set(0, 0, 2);
        matrix.set(0, 1, 1);
        matrix.set(0, 2, -1);
        matrix.set(1, 0, -3);
        matrix.set(1, 1, -1);
        matrix.set(1, 2, 2);
        matrix.set(2, 0, -2);
        matrix.set(2, 1, 1);
        matrix.set(2, 2, 2);
        Matrix result = matrix.gaussianElimination();
        System.out.println("Matrix after Gaussian elimination:");
        System.out.println(result);
    }

    private static void testGaussJordanElimination() {
        Matrix matrix = new Matrix(3, 3);
        matrix.set(0, 0, 2);
        matrix.set(0, 1, 1);
        matrix.set(0, 2, -1);
        matrix.set(1, 0, -3);
        matrix.set(1, 1, -1);
        matrix.set(1, 2, 2);
        matrix.set(2, 0, -2);
        matrix.set(2, 1, 1);
        matrix.set(2, 2, 2);
        Matrix result = matrix.gaussJordanElimination();
        System.out.println("Matrix after Gauss-Jordan elimination:");
        System.out.println(result);
    }

    private static void testSolveFor() {
        Matrix matrix = new Matrix(3, 3);
        matrix.set(0, 0, 2);
        matrix.set(0, 1, 1);
        matrix.set(0, 2, -1);
        matrix.set(1, 0, -3);
        matrix.set(1, 1, -1);
        matrix.set(1, 2, 2);
        matrix.set(2, 0, -2);
        matrix.set(2, 1, 1);
        matrix.set(2, 2, 2);
        double[][] constants = {{7}, {-1}, {5}};
        Map<Character, Double> solutions = matrix.solveFor(constants);
        System.out.println("Solutions for variables a, b, and c:");
        System.out.println(solutions);
    }

    private static void testAddition() {
        Matrix matrix1 = new Matrix(2, 2);
        matrix1.set(0, 0, 1);
        matrix1.set(0, 1, 2);
        matrix1.set(1, 0, 3);
        matrix1.set(1, 1, 4);
        Matrix matrix2 = new Matrix(2, 2);
        matrix2.set(0, 0, 5);
        matrix2.set(0, 1, 6);
        matrix2.set(1, 0, 7);
        matrix2.set(1, 1, 8);
        Matrix result = matrix1.add(matrix2);
        System.out.println("Result of addition:");
        System.out.println(result);
    }

    private static void testSubtraction() {
        Matrix matrix1 = new Matrix(2, 2);
        matrix1.set(0, 0, 1);
        matrix1.set(0, 1, 2);
        matrix1.set(1, 0, 3);
        matrix1.set(1, 1, 4);
        Matrix matrix2 = new Matrix(2, 2);
        matrix2.set(0, 0, 5);
        matrix2.set(0, 1, 6);
        matrix2.set(1, 0, 7);
        matrix2.set(1, 1, 8);
        Matrix result = matrix1.minus(matrix2);
        System.out.println("Result of subtraction:");
        System.out.println(result);
    }

    private static void testMultiplication() {
        Matrix matrix1 = new Matrix(2, 2);
        matrix1.set(0, 0, 1);
        matrix1.set(0, 1, 2);
        matrix1.set(1, 0, 3);
        matrix1.set(1, 1, 4);
        Matrix matrix2 = new Matrix(2, 2);
        matrix2.set(0, 0, 5);
        matrix2.set(0, 1, 6);
        matrix2.set(1, 0, 7);
        matrix2.set(1, 1, 8);
        Matrix result = matrix1.multiply(matrix2);
        System.out.println("Result of multiplication:");
        System.out.println(result);
    }

    private static void testTranspose() {
        Matrix matrix = new Matrix(2, 3);
        matrix.set(0, 0, 1);
        matrix.set(0, 1, 2);
        matrix.set(0, 2, 3);
        matrix.set(1, 0, 4);
        matrix.set(1, 1, 5);
        matrix.set(1, 2, 6);
        Matrix transposed = matrix.tranpose();
        System.out.println("Transposed matrix:");
        System.out.println(transposed);
    }

    private static void testPrincipalDiagonal() {
        Matrix matrix = new Matrix(3, 3);
        matrix.set(0, 0, 1);
        matrix.set(1, 1, 2);
        matrix.set(2, 2, 3);
        double[] principalDiagonal = matrix.principalDiagonal();
        System.out.println("Principal Diagonal:");
        for (double diagonalElement : principalDiagonal) {
            System.out.println(diagonalElement);
        }
    }

    private static void testSecondaryDiagonal() {
        Matrix matrix = new Matrix(3, 3);
        matrix.set(0, 2, 1);
        matrix.set(1, 1, 2);
        matrix.set(2, 0, 3);
        double[] secondaryDiagonal = matrix.secondaryDiagonal();
        System.out.println("Secondary Diagonal:");
        for (double diagonalElement : secondaryDiagonal) {
            System.out.println(diagonalElement);
        }
    }

}

