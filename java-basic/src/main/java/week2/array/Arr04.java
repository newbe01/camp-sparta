package week2.array;

public class Arr04 {
    public static void main(String[] args) {

        // 2차원배열
        int[][] arr = new int[2][3];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println("i + j = " + i + j);
                arr[i][j] = 0;
            }
        }

        // 가변배열
        int[][] arr2 = new int[3][];

        arr2[0] = new int[2];
        arr2[1] = new int[3];
        arr2[2] = new int[4];

        int[][] arr3 = {
                {1, 2},
                {1, 2, 3, 4},
                {1, 2, 3, 4, 5}
        };

    }
}
