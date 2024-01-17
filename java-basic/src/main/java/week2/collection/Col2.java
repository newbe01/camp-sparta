package week2.collection;

import java.util.LinkedList;
import java.util.List;

public class Col2 {
    public static void main(String[] args) {

        // Linked List 조회는 느림, 추가, 삭제는 빠름
        List<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println("list.get(0) = " + list.get(0));
        System.out.println("list.get(0) = " + list.get(1));
        System.out.println("list.get(0) = " + list.get(2));
        System.out.println("list.toString() = " + list.toString());

        list.add(200);
        System.out.println("list.toString() = " + list.toString());

        list.add(2, 400);
        System.out.println("list.toString() = " + list.toString());

        list.set(1, 3000);
        System.out.println("list.toString() = " + list.toString());

        list.remove(0);
        System.out.println("list.toString() = " + list.toString());

        list.clear();
        System.out.println("list.toString() = " + list.toString());

    }
}
