package week2.array;

import java.util.Arrays;

public class Arr01 {
    public static void main(String[] args) {
        // array
        int[] intArray = new int[3];
        boolean[] boolArray = new boolean[3];
        String[] stringArray = new String[3];

        int[] intArray2;
        intArray2 = new int[4];

        // find
        System.out.println(intArray[1]);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println("intArray[i] = " + intArray[i]);
        }

        System.out.println("====================================");
        // init
        int[] arr = {1, 2, 3, 4, 5};
        String[] strArr = {"a", "b", "c", "d"};

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[i] = " + arr[i]);
        }

        for (int i : arr) {
            System.out.println("i = " + i);
        }

        Arrays.fill(arr, 1);
        Arrays.stream(arr).forEach(System.out::println);

    }
}
