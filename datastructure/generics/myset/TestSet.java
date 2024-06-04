package yukwork.datastructure.generics.myset;

import yukwork.datastructure.generics.myset.myhashset.MyChainingHashSet;
import yukwork.datastructure.generics.myset.myhashset.MyOpenAddressingHashSet;
import yukwork.datastructure.generics.myset.mylinkedhashset.MyLinkedHashSet;
import yukwork.datastructure.generics.myset.mytreeset.MyTreeSet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class TestSet {

    public static void main(String[] args) {
        testMySet(new MyChainingHashSet<>(), new MyChainingHashSet<>());
        testMySet(new MyOpenAddressingHashSet<>(), new MyOpenAddressingHashSet<>());
        testMySet(new MyTreeSet<>(), new MyTreeSet<>());
        testMySet(new MyLinkedHashSet<>(), new MyLinkedHashSet<>());
    }

    public static void testMySet(MySet<Integer> toTest, MySet<Integer> another) {
        System.out.println("Testing " + toTest.getClass().getSimpleName());

        toTest.add(1);
        toTest.add(2);
        toTest.add(3);

        toTest.add(1);
        toTest.add(22);
        toTest.add(33);

        System.out.println("Initial set: " + toTest.toList());

        assert toTest.size() == 3 : "Size should be 3";
        assert toTest.contains(1) : "Set should contain 1";
        assert toTest.contains(2) : "Set should contain 2";
        assert toTest.contains(3) : "Set should contain 3";

        toTest.remove(2);
        System.out.println("After removal of 2: " + toTest.toList());

        assert toTest.size() == 2 : "Size should be 2 after removal";
        assert !toTest.contains(2) : "Set should not contain 2 after removal";

        List<Integer> list = toTest.toList();
        assert new HashSet<>(list).containsAll(Arrays.asList(1, 3)) : "List should contain 1 and 3";

        another.add(3);
        another.add(4);

        System.out.println("Second set: " + another.toList());

        MySet<Integer> unionSet = toTest.union(another);
        System.out.println("Union set: " + unionSet.toList());
        assert unionSet.size() == 3 : "Union set size should be 3";
        assert unionSet.contains(1) && unionSet.contains(3) && unionSet.contains(4) : "Union set should contain 1, 3, 4";

        MySet<Integer> intersectionSet = toTest.intersection(another);
        System.out.println("Intersection set: " + intersectionSet.toList());
        assert intersectionSet.size() == 1 : "Intersection set size should be 1";
        assert intersectionSet.contains(3) : "Intersection set should contain 3";

        MySet<Integer> differenceSet = toTest.difference(another);
        System.out.println("Difference set: " + differenceSet.toList());
        assert differenceSet.size() == 1 : "Difference set size should be 1";
        assert differenceSet.contains(1) : "Difference set should contain 1";

        toTest.clear();
        System.out.println("After clear: " + toTest.toList());
        assert toTest.isEmpty() : "Set should be empty after clear";

        System.out.println("All tests passed.");
    }

}