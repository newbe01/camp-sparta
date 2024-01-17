package week2.operator;

public class W05 {
    public static void main(String[] args) {

        // 기본 대입연산자
        int num = 10;
        num = num +2;
        System.out.println("num = " + num);

        num = num - 2;
        System.out.println("num = " + num);

        num = num * 2;
        System.out.println("num = " + num);

        num = num / 2;
        System.out.println("num = " + num);

        num = num % 2;
        System.out.println("num = " + num);
        System.out.println("---------------------");

        // 복합 대입연산자
        num = 10;

        num += 2;
        System.out.println("num = " + num);

        num -= 2;
        System.out.println("num = " + num);

        num *= 2;
        System.out.println("num = " + num);

        num /= 2;
        System.out.println("num = " + num);

        num %= 2;
        System.out.println("num = " + num);

        System.out.println("---------------------");

        // ++, --
        num++;
        System.out.println("num = " + num);

        num--;
        System.out.println("num = " + num);


    }
}
