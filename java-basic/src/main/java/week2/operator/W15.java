package week2.operator;

public class W15 {
    public static void main(String[] args) {

        // for
        for (int i = 0; i < 4; i++) {
            System.out.println(i);
        }

        // for
        int[] arr = {1, 2, 3, 4, 5, 6};

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        for (int num : arr) {
            System.out.println(num);
        }
    }
}
