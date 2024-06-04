package yukwork.linearalgebra.vector;

import java.util.Arrays;

public class ArrayVector implements IVector {

    private static final int DEFAULT_CAPACITY = 2;
    private double[] data;
    private int length;

    public ArrayVector() {
        data = new double[DEFAULT_CAPACITY];
        length = 0;
    }

    public ArrayVector(double[] data) {
        this.data = data;
        length = data.length;
    }

    @Override
    public void append(double value) {
        if (length >= data.length) extend();
        data[length++] = value;
    }

    @Override
    public double element(int index) {
        checkBound(index, length);
        return data[index];
    }

    @Override
    public double[] elements() {
        return Arrays.copyOf(data, length);
    }

    @Override
    public void insert(int index, double value) {
        checkBound(index, length + 1);
        if (length >= data.length) extend();
        System.arraycopy(data, index, data, index + 1, length - index);
        data[index] = value;
        length++;
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public double magnitude() {
        double magnitude = 0;
        for (int i = 0; i < length; i++) {
            magnitude += data[i] * data[i];
        }
        return Math.sqrt(magnitude);
    }

    @Override
    public void remove(int index) {
        checkBound(index, length);
        System.arraycopy(data, index + 1, data, index, length - index);
        length--;
    }

    public double distanceTo(ArrayVector another) {
        ArrayVector dummyVector = new ArrayVector(elements());
        ArrayVector anotherDummyVector = new ArrayVector(another.elements());
        if (length != another.length) {
            int dLength = Math.abs(length - another.length);
            for (int i = 0; i < dLength; i++) {
                if (length < another.length) dummyVector.append(0);
                else anotherDummyVector.append(0);
            }
        }
        double distance = 0;
        for (int i = 0; i < dummyVector.length; i++) {
            distance += (dummyVector.data[i] - anotherDummyVector.data[i]) * (dummyVector.data[i] - anotherDummyVector.data[i]);
        }
        return Math.sqrt(distance);
    }

    public double dot(ArrayVector another) {
        double dotProduct = 0;
        for (int i = 0; i < Math.min(length, another.length); i++) {
            dotProduct += data[i] * another.data[i];
        }
        return dotProduct;
    }

    public ArrayVector scale(double scalar) {
        ArrayVector scaled = new ArrayVector(elements());
        for (int i = 0; i < length; i++) {
            scaled.data[i] *= scalar;
        }
        return scaled;
    }

    public ArrayVector plus(ArrayVector another) {
        if (length != another.length) throw new IllegalArgumentException("Vectors are not of same size");
        ArrayVector result = new ArrayVector();
        for (int i = 0; i < length; i++) {
            result.append(data[i] + another.data[i]);
        }
        return result;
    }

    public ArrayVector minus(ArrayVector another) {
        if (length != another.length) throw new IllegalArgumentException("Vectors are not of same size");
        ArrayVector result = new ArrayVector();
        for (int i = 0; i < length; i++) {
            result.append(data[i] - another.data[i]);
        }
        return result;
    }

    public ArrayVector cross(ArrayVector another) {
        if (length != 3 || another.length != 3) throw new IllegalArgumentException("Cross product is only defined for 3D vectors");
        double x = data[1] * another.data[2] - data[2] * another.data[1];
        double y = data[2] * another.data[0] - data[0] * another.data[2];
        double z = data[0] * another.data[1] - data[1] * another.data[0];
        return new ArrayVector(new double[]{x, y, z});
    }

    public double angleTo(ArrayVector another) {
        double dotProduct = this.dot(another);
        double magnitudes = this.magnitude() * another.magnitude();
        return Math.acos(dotProduct / magnitudes);
    }

    public ArrayVector projectOnto(ArrayVector another) {
        double scalarProjection = this.dot(another) / another.dot(another);
        return another.scale(scalarProjection);
    }

    public ArrayVector normalize() {
        double mag = this.magnitude();
        if (mag == 0) throw new ArithmeticException("Cannot normalize a zero vector");
        return this.scale(1 / mag);
    }

    public ArrayVector reflect(ArrayVector normal) {
        ArrayVector normalizedNormal = normal.normalize();
        double dotProduct = this.dot(normalizedNormal);
        return this.minus(normalizedNormal.scale(2 * dotProduct));
    }

    public ArrayVector rotate(double angle) {
        if (length != 2) throw new UnsupportedOperationException("Rotation is only supported for 2D vectors");
        double cosTheta = Math.cos(angle);
        double sinTheta = Math.sin(angle);
        double x = data[0] * cosTheta - data[1] * sinTheta;
        double y = data[0] * sinTheta + data[1] * cosTheta;
        return new ArrayVector(new double[]{x, y});
    }

    private void extend() {
        double[] newData = new double[data.length * 2];
        System.arraycopy(data, 0, newData, 0, length);
        data = newData;
    }

    private void checkBound(int index, int limit) {
        if (index < 0 || index >= limit) throw new IndexOutOfBoundsException("Invalid index.");
    }

    @Override
    public String toString() {
        StringBuilder vector = new StringBuilder("[");
        for (int i = 0; i < length; i++) {
            if (i == length - 1) vector.append(data[i]);
            else vector.append(data[i]).append(", ");
        }
        return vector.append("]").toString();
    }

}
