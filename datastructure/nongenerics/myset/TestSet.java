package yukwork.datastructure.nongenerics.myset;

import yukwork.datastructure.nongenerics.myset.myhashset.MyChainingHashSet;
import yukwork.datastructure.nongenerics.myset.myhashset.MyOpenAddressingHashSet;

public class TestSet {

    public static void main(String[] args) {
        System.out.println("Hash Set with Chaining: ");
        testSet(new MyChainingHashSet());
        System.out.println("Hash Set with Open Addressing: ");
        testSet(new MyOpenAddressingHashSet());
    }

    private static void testSet(MySet set) {
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("A");

        System.out.println("Size: " + set.size());
        System.out.println("Contents: " + set);

        System.out.println("Contains 'B': " + set.contains("B"));
        System.out.println("Contains 'D': " + set.contains("D"));

        Object[] array = set.toArray();
        System.out.println("Array: " + java.util.Arrays.toString(array));
        java.util.List<Object> list = set.toList();
        System.out.println("List: " + list);

        set.remove("B");
        System.out.println("After removing 'B': " + set);

        set.clear();
        System.out.println("After clearing: " + set);
        System.out.println("Is set empty? " + set.isEmpty());

        MySet set2 = new MyOpenAddressingHashSet();
        set2.add("C");
        set2.add("D");
        set2.add("E");
        System.out.println("\nSet 1: " + set);
        System.out.println("Set 2: " + set2);
        System.out.println("Union: " + set.union(set2));
        System.out.println("Intersection: " + set.intersection(set2));
        System.out.println("Difference: " + set.difference(set2));
        System.out.println();
    }

}
