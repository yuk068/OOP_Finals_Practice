package yukwork.datastructure.generics.mymap;

import yukwork.datastructure.generics.mymap.myhashmap.MyHashMap;

public class TestMap {

    public static void main(String[] args) {
        testMyHashMap();
    }
    
    public static void testMyHashMap() {
        MyMap<String, Integer> map = new MyHashMap<>();

        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("Four", 4);
        map.put("Five", 5);
        map.put("Six", 6);
        map.put("Seven", 7);

        map.put("Yuk of war", 8);
        map.put("Freeman", 9);
        map.put("Real", 10);
        map.put("Why", 11);
        map.put("Why", 13);
        map.put("How", 11);
        map.put("How", 13);

        map.put("Phi", 1618);
        map.put("Euler", 2718);
        map.put("Pi", 3141);

        System.out.println("Get 'Three': " + map.get("Three")); 

        System.out.println("Contains 'Five': " + map.containsKey("Five")); 
        System.out.println("Contains 'Ten': " + map.containsKey("Ten")); 

        System.out.println("Size: " + map.size()); 

        map.removeByKey("Two");
        System.out.println("Removed 'Two'. Size: " + map.size()); 
        System.out.println("Contains 'Two': " + map.containsKey("Two")); 

        map.removeByValue(4);
        System.out.println("Removed value 4. Size: " + map.size()); 
        System.out.println("Contains 'Four': " + map.containsKey("Four")); 

        map.setValueAt("Three", 33);
        System.out.println("Set 'Three' to 33. Get 'Three': " + map.get("Three")); 

        System.out.println("Contains value 33: " + map.containsValue(33)); 
        System.out.println("Contains value 3: " + map.containsValue(3)); 

        System.out.println("Map contents:\n" + map);
        System.out.println("Map structure:\n" + map.getMapStructure());
        System.out.println("Size: " + map.size());
    }
    
}
