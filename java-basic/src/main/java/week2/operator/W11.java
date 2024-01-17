package week2.operator;

public class W11 {
    public static void main(String[] args) {
        // if -

        boolean flag = true;

        if (flag) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }


        // if - else
        int num = 2;
        if (num == 1) {
            System.out.println("num 1");
        } else if (num == 2) {
            System.out.println("num 2");
        } else {
            System.out.println("else");
        }

        // 중첩 if
        if (flag) {
            System.out.println("true");
            if (num == 1) {
                System.out.println("true, 1");
            } else if (num == 2) {
                System.out.println("true, 2");
            } else {
                System.out.println("true, ??");
            }
        } else {
            System.out.println("false");
            if (num == 1) {
                System.out.println("false, 1");
            } else if (num == 2) {
                System.out.println("false, 2");
            } else {
                System.out.println("false, ??");
            }
        }

    }
}
