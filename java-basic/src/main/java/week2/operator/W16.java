package week2.operator;

public class W16 {
    public static void main(String[] args) {

        int num = 0;

        // while
        while (num < 3) {
            num++;
            System.out.println("num = " + num);
        }

        System.out.println("==============================");
        // do while
        num = 4;
        do {
            System.out.println(num);    // 조건 만족하지않아도 최초1번은 수행
        } while (num < 3);

        System.out.println("==============================");
        // break
        num = 0;
        while (num < 3) {
            num ++;
            if (num == 2) {
                break;
            }
            System.out.println("num = " + num);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("i = " + i);
            if (i == 2) {
                break;
            }
            for (int j = 0; j < 10; j++) {
                System.out.println("j = " + j);
                if (j == 2) {
                    break;
                }
            }
        }

        System.out.println("==============================");
        // continue
        num = 0;
        while (num < 3) {
            num++;
            if (num == 2) {
                continue;
            }
            System.out.println("num = " + num);
        }

    }
}
