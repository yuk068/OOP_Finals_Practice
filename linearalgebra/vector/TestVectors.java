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
    }

}
