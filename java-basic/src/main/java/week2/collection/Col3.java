package week2.collection;

import java.util.*;

public class Col3 {
    public static void main(String[] args) {

        // stack FILO
        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(15);
        stack.push(20);

        System.out.println("stack.peek() = " + stack.peek());
        System.out.println("stack.size() = " + stack.size());
        
        while (!stack.isEmpty()) {
            System.out.println("stack.pop() = " + stack.pop());
        }

        System.out.println("======================================");

        // queue FIFO
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(3);
        queue.add(5);

        System.out.println("queue.peek() = " + queue.peek());
        System.out.println("queue.size() = " + queue.size());

        while (!queue.isEmpty()) {
            System.out.println("queue.poll() = " + queue.poll());
        }

        System.out.println("======================================");

        // set
        Set<Integer> set = new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(5);

        for (Integer integer : set) {
            System.out.println("integer = " + integer);
        }

        System.out.println("set.contains(2) = " + set.contains(2));
        System.out.println("set.contains(2) = " + set.contains(8));

        System.out.println("======================================");

        // map
        Map<String, Integer> map = new HashMap<>();

        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        map.put("4", 4);
        map.put("4", 5);
        map.put("4", 6);

        for (String s : map.keySet()) {
            System.out.println("s = " + s);
        }

        for (String s : map.keySet()) {
            System.out.println("map.get(s) = " + map.get(s));
        }



    }
}
