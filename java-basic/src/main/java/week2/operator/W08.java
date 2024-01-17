package week2.operator;

public class W08 {
    public static void main(String[] args) {
        // 연산자 우선순위
        int x = 2;
        int y = 9;
        int z = 10;

        boolean result = x < y && y < z;
        System.out.println("result = " + result);

        result = x + 10 < y && y < z;
        System.out.println("result = " + result);

        result = x + 2 * 3 > y;
        System.out.println("result = " + result);

        result = (x + 2) * 3 > y;
        System.out.println("result = " + result);
    }
}
