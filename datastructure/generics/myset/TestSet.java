package yukwork.datastructure.generics.myset;

import yukwork.datastructure.generics.myset.myhashset.MyChainingHashSet;
import yukwork.datastructure.generics.myset.myhashset.MyOpenAddressingHashSet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class TestSet {

    public static void main(String[] args) {
        testMyChainingHashSet();
        testMyOpenAddressingHashSet();
    }

    private static void testMyChainingHashSet() {
        System.out.println("Testing MyChainingHashSet...");

        MySet<Integer> set = new MyChainingHashSet<>();

        set.add(1);
        set.add(2);
        set.add(3);

        assert set.size() == 3 : "Size should be 3";
        assert set.contains(1) : "Set should contain 1";
        assert set.contains(2) : "Set should contain 2";
        assert set.contains(3) : "Set should contain 3";

        set.remove(2);
        assert set.size() == 2 : "Size should be 2 after removal";
        assert !set.contains(2) : "Set should not contain 2 after removal";

        List<Integer> list = set.toList();
        assert new HashSet<>(list).containsAll(Arrays.asList(1, 3)) : "List should contain 1 and 3";

        MySet<Integer> anotherSet = new MyChainingHashSet<>();
        anotherSet.add(3);
        anotherSet.add(4);

        MySet<Integer> unionSet = set.union(anotherSet);
        assert unionSet.size() == 3 : "Union set size should be 3";
        assert unionSet.contains(1) && unionSet.contains(3) && unionSet.contains(4) : "Union set should contain 1, 3, 4";

        MySet<Integer> intersectionSet = set.intersection(anotherSet);
        assert intersectionSet.size() == 1 : "Intersection set size should be 1";
        assert intersectionSet.contains(3) : "Intersection set should contain 3";

        MySet<Integer> differenceSet = set.difference(anotherSet);
        assert differenceSet.size() == 1 : "Difference set size should be 1";
        assert differenceSet.contains(1) : "Difference set should contain 1";

        set.clear();
        assert set.isEmpty() : "Set should be empty after clear";

        System.out.println("MyChainingHashSet tests passed.");
    }

    private static void testMyOpenAddressingHashSet() {
        System.out.println("Testing MyOpenAddressingHashSet...");

        MySet<Integer> set = new MyOpenAddressingHashSet<>();

        set.add(1);
        set.add(2);
        set.add(3);

        assert set.size() == 3 : "Size should be 3";
        assert set.contains(1) : "Set should contain 1";
        assert set.contains(2) : "Set should contain 2";
        assert set.contains(3) : "Set should contain 3";

        set.remove(2);
        assert set.size() == 2 : "Size should be 2 after removal";
        assert !set.contains(2) : "Set should not contain 2 after removal";

        List<Integer> list = set.toList();
        assert new HashSet<>(list).containsAll(Arrays.asList(1, 3)) : "List should contain 1 and 3";

        MySet<Integer> anotherSet = new MyOpenAddressingHashSet<>();
        anotherSet.add(3);
        anotherSet.add(4);

        MySet<Integer> unionSet = set.union(anotherSet);
        assert unionSet.size() == 3 : "Union set size should be 3";
        assert unionSet.contains(1) && unionSet.contains(3) && unionSet.contains(4) : "Union set should contain 1, 3, 4";

        MySet<Integer> intersectionSet = set.intersection(anotherSet);
        assert intersectionSet.size() == 1 : "Intersection set size should be 1";
        assert intersectionSet.contains(3) : "Intersection set should contain 3";

        MySet<Integer> differenceSet = set.difference(anotherSet);
        assert differenceSet.size() == 1 : "Difference set size should be 1";
        assert differenceSet.contains(1) : "Difference set should contain 1";

        set.clear();
        assert set.isEmpty() : "Set should be empty after clear";

        System.out.println("MyOpenAddressingHashSet tests passed.");
    }
}