package yukwork.linearalgebra.vector;

public class TestVectors {

    public static void main(String[] args) {
        testArrayVector();
        System.out.println();
        testListVector();
    }

    public static void testArrayVector() {
        System.out.println("Test ArrayVector: ");
        ArrayVector vector1 = new ArrayVector();
        vector1.append(1);
        vector1.append(2);
        vector1.append(3);
        System.out.println("Vector 1: " + vector1);

        ArrayVector vector2 = new ArrayVector(new double[]{4.0, 5.0, 6.0});
        System.out.println("Vector 2: " + vector2);

        System.out.println("Vector 1 + Vector 2: " + vector1.plus(vector2));
        System.out.println("Vector 1 - Vector 2: " + vector1.minus(vector2));
        System.out.println("Vector 1 * 3: " + vector1.scale(3));
        System.out.println("|Vector 1|: " + vector1.magnitude());
        System.out.println("Vector 1 . Vector 2: " + vector1.dot(vector2));
        System.out.println("d(Vector 1, Vector 2): " + vector1.distanceTo(vector2));
        System.out.println("Normalized Vector 1: " + vector1.normalize());
        System.out.println("Cross product of Vector 1 and Vector 2: " + vector1.cross(vector2));
        System.out.println("Angle from Vector 1 to Vector 2: " + vector1.angleTo(vector2));
        System.out.println("Projection of Vector 1 onto Vector 2: " + vector1.projectOnto(vector2));
        System.out.println("Normalized Vector 1: " + vector1.normalize());
        System.out.println("Reflection of Vector 1 with normal Vector 2: " + vector1.reflect(vector2));
        ArrayVector vector2D = new ArrayVector(new double[]{0.0, 1.0});
        System.out.println("Rotation of Vector 1 by PI/4: " + vector2D.rotate(Math.PI / 4));
    }

    public static void testListVector() {
        System.out.println("Test ListVector: ");
        ListVector vector1 = new ListVector();
        vector1.append(1);
        vector1.append(2);
        vector1.append(3);
        System.out.println("Vector 1: " + vector1);

        ListVector vector2 = new ListVector();
        vector2.append(4);
        vector2.append(5);
        vector2.append(6);
        System.out.println("Vector 2: " + vector2);

        System.out.println("Vector 1 + Vector 2: " + vector1.plus(vector2));
        System.out.println("Vector 1 - Vector 2: " + vector1.minus(vector2));
        System.out.println("Vector 1 * 3: " + vector1.scale(3));
        System.out.println("|Vector 1|: " + vector1.magnitude());
        System.out.println("Vector 1 . Vector 2: " + vector1.dot(vector2));
        System.out.println("d(Vector 1, Vector 2): " + vector1.distanceTo(vector2));
        System.out.println("Normalized Vector 1: " + vector1.normalize());
        System.out.println("Cross product of Vector 1 and Vector 2: " + vector1.cross(vector2));
        System.out.println("Angle from Vector 1 to Vector 2: " + vector1.angleTo(vector2));
        System.out.println("Projection of Vector 1 onto Vector 2: " + vector1.projectOnto(vector2));
        System.out.println("Normalized Vector 1: " + vector1.normalize());
        System.out.println("Reflection of Vector 1 with normal Vector 2: " + vector1.reflect(vector2));
        ListVector vector2D = new ListVector();
        vector2D.append(0.0);
        vector2D.append(1.0);
        System.out.println("Rotation of Vector 1 by PI/4: " + vector2D.rotate(Math.PI / 4));
    }

}
