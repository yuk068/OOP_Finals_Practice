package yukwork.datastructure.nongenerics.mymap;

import yukwork.datastructure.nongenerics.mymap.myhashmap.MyHashMap;

public class TestMap {

    public static void main(String[] args) {
        testMyHashMap();
    }
    
    public static void testMyHashMap() {
        MyMap map = new MyHashMap();

        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("Four", 4);
        map.put("Five", 5);
        map.put("Six", 6);
        map.put("Seven", 7);

        map.put("Yuk of war", "Yuk of pain");
        map.put("Freeman", "Low");
        map.put("Real", "Fake");
        map.put("Why", "Now");

        map.put("Phi", 1.618);
        map.put("Euler", 2.718);
        map.put("Pi", 3.141);

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
    }
    
}
