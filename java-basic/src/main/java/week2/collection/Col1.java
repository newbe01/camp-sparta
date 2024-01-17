package week2.collection;

import java.util.ArrayList;
import java.util.List;

public class Col1 {
    public static void main(String[] args) {

        // List
        List<Integer> intList = new ArrayList<>();

        intList.add(1);
        intList.add(2);
        intList.add(3);

        System.out.println("intList.get(0) = " + intList.get(1));

        intList.set(1, 4);
        System.out.println("intList.get(2) = " + intList.get(1));

        intList.remove(0);
        System.out.println("intList.get(0) = " + intList.get(0));

        System.out.println("intList.toString() = " + intList.toString());
        intList.clear();
        System.out.println("intList.toString() = " + intList.toString());
    }
}
