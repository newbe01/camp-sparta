package week2.array;

public class Arr05 {
    public static void main(String[] args) {
        // max, min value
        int[] arr = {3, 2, 1, 5, 4};

        int min = arr[0];
        int max = arr[0];

        for (int num : arr) {
            if (num > max) {
                max = num;
            }

            if (num < min) {
                min = num;
            }
        }

        System.out.println("max = " + max);
        System.out.println("min = " + min);
    }
}
