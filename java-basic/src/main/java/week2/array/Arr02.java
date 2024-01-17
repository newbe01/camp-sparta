package week2.array;

import java.util.Arrays;

public class Arr02 {
    public static void main(String[] args) {
        // 얕은복사
        int[] a = {1, 2, 3, 4};
        int[] b = a;

        b[0] = 3;

        System.out.println("a[0] = " + a[0]);

        // 깊은복사
        b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }

        b = a.clone(); // 2차원 배열 이상에서는 얕은복사로 동작

        b = Arrays.copyOf(a, a.length);
        a[3] = 0;

        System.out.println("a[3] = " + a[3]);
        System.out.println("b[3] = " + b[3]);

    }
}
