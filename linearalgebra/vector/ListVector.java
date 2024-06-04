package yukwork.linearalgebra.vector;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ListVector implements IVector {

    private final List<Double> data;

    public ListVector() {
        data = new LinkedList<>();
    }

    public ListVector(List<Double> data) {
        this.data = data;
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
    public double[] elements() {
        return data.stream().mapToDouble(Double::valueOf).toArray();
    }

    @Override
    public void insert(int index, double value) {
        checkBound(index, data.size() + 1);
        data.add(index, value);
    }

    @Override
    public int length() {
        return data.size();
    }

    @Override
    public double magnitude() {
        return Math.sqrt(data.stream().mapToDouble(value -> value * value).sum());
    }

    @Override
    public void remove(int index) {
        checkBound(index, data.size());
        data.remove(index);
    }

    public double distanceTo(ListVector another) {
        ListVector dummyVector = new ListVector(Arrays.stream(elements()).boxed().collect(Collectors.toList()));
        ListVector anotherDummyVector = new ListVector(Arrays.stream(another.elements()).boxed().collect(Collectors.toList()));
        if (data.size() != another.data.size()) {
            int dLength = Math.abs(data.size() - another.data.size());
            for (int i = 0; i < dLength; i++) {
                if (data.size() < another.data.size()) dummyVector.append(0);
                else anotherDummyVector.append(0);
            }
        }
        double distance = 0;
        for (int i = 0; i < dummyVector.data.size(); i++) {
            distance += (dummyVector.element(i) - anotherDummyVector.element(i)) * (dummyVector.element(i) - anotherDummyVector.element(i));
        }
        return Math.sqrt(distance);
    }

    public double dot(ListVector another) {
        double dotProduct = 0;
        for (int i = 0; i < Math.min(data.size(), another.data.size()); i++) {
            dotProduct += element(i) * another.element(i);
        }
        return dotProduct;
    }

    public ListVector scale(double scalar) {
        ListVector scaled = new ListVector();
        for (int i = 0; i < data.size(); i++) {
            scaled.append(element(i) * scalar);
        }
        return scaled;
    }

    public ListVector plus(ListVector another) {
        if (data.size() != another.data.size()) throw new IllegalArgumentException("Vectors are not of same size");
        ListVector result = new ListVector();
        for (int i = 0; i < data.size(); i++) {
            result.append(element(i) + another.element(i));
        }
        return result;
    }

    public ListVector minus(ListVector another) {
        if (data.size() != another.data.size()) throw new IllegalArgumentException("Vectors are not of same size");
        ListVector result = new ListVector();
        for (int i = 0; i < data.size(); i++) {
            result.append(element(i) - another.element(i));
        }
        return result;
    }

    public ListVector cross(ListVector another) {
        if (data.size() != 3 || another.data.size() != 3) throw new IllegalArgumentException("Cross product is only defined for 3D vectors");
        double x = data.get(1) * another.data.get(2) - data.get(2) * another.data.get(1);
        double y = data.get(2) * another.data.get(0) - data.get(0) * another.data.get(2);
        double z = data.get(0) * another.data.get(1) - data.get(1) * another.data.get(0);
        return new ListVector(Arrays.asList(x, y, z));
    }

    public double angleTo(ListVector another) {
        double dotProduct = this.dot(another);
        double magnitudes = this.magnitude() * another.magnitude();
        return Math.acos(dotProduct / magnitudes);
    }

    public ListVector projectOnto(ListVector another) {
        double scalarProjection = this.dot(another) / another.dot(another);
        return another.scale(scalarProjection);
    }

    public ListVector normalize() {
        double mag = this.magnitude();
        if (mag == 0) throw new ArithmeticException("Cannot normalize a zero vector");
        return this.scale(1 / mag);
    }

    public ListVector reflect(ListVector normal) {
        ListVector normalizedNormal = normal.normalize();
        double dotProduct = this.dot(normalizedNormal);
        return this.minus(normalizedNormal.scale(2 * dotProduct));
    }

    public ListVector rotate(double angle) {
        if (data.size() != 2) throw new UnsupportedOperationException("Rotation is only supported for 2D vectors");
        double cosTheta = Math.cos(angle);
        double sinTheta = Math.sin(angle);
        double x = data.get(0) * cosTheta - data.get(1) * sinTheta;
        double y = data.get(0) * sinTheta + data.get(1) * cosTheta;
        return new ListVector(Arrays.asList(x, y));
    }

    private void checkBound(int index, int limit) {
        if (index < 0 || index >= limit) throw new IndexOutOfBoundsException("Invalid index.");
    }

    @Override
    public String toString() {
        StringBuilder vector = new StringBuilder("[");
        for (int i = 0; i < data.size(); i++) {
            if (i == data.size() - 1) vector.append(data.get(i));
            else vector.append(data.get(i)).append(", ");
        }
        return vector.append("]").toString();
    }

}
