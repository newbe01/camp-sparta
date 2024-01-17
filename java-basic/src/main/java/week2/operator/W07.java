package week2.operator;

public class W07 {
    public static void main(String[] args) {
        // 기타연산자
        // 형변환 연산자
        int intNum = 93 + (int) 98.8;
        System.out.println("intNum = " + intNum);

        double doubleNum = (double)93 + 98.8;
        System.out.println("doubleNum = " + doubleNum);

        // 삼항연산자
        int x = 1;
        int y = 9;

        boolean b = x == y ? true : false;
        System.out.println("b = " + b);

        String s = x != y ? "O" : "X";
        System.out.println("s = " + s);

        int max = x > y ? x : y;
        System.out.println("max = " + max);

        int min = x < y ? x : y;
        System.out.println("min = " + min);

        // instance of
    }
}
