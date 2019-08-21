package sample.java;

import java.util.LinkedHashMap;

public class CollectionTest {

    public static void main(String[] args) {

        LinkedHashMap map = new LinkedHashMap();

        map.put(1.5, "Joe");
        map.put(1,"Jan");
        map.put(2,"Feb");
        map.put(3,"Mar");

        System.out.println(map);

    }
}
