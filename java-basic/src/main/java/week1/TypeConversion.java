package week1;

public class TypeConversion {
    public static void main(String[] args) {

        // 실수 -> 정수
        double doubleNum = 10.11111;
        float floatNum = 10.111F;

        int intNum;
        intNum = (int) doubleNum;
        intNum = (int) floatNum;

        // 정수 -> 실수
        int integerNum = 10;
        double douNum = (double) integerNum;
        float flNum = (float) integerNum;

        // byte(1byte) -> short(2) -> int(4) -> long(8) -> float(4) -> double(8)
        // byte -> int
        int conversionNum;
        byte byteNum = 10;
        conversionNum= byteNum;
        System.out.println("conversionNum = " + conversionNum);

        // char -> int
        char ch = 'A';
        conversionNum = ch;
        System.out.println("conversionNum = " + conversionNum);

        // int -> long
        conversionNum = 100;
        long longNum = conversionNum;
        System.out.println("longNum = " + longNum);

        // int -> double
        conversionNum = 1000;
        double doubleNumber = conversionNum;
        System.out.println("doubleNumber = " + doubleNumber);

        // 작은 크기의 타입이 큰 크기의 타입과 계산될때 자동으로 큰 타입으로 형변환
        int a = 10;
        double b = 10.10;
        double sum = a + b;
        System.out.println("sum = " + sum);

        // 정수로나누기
        int iResult = a / 4;

        // 실수로나누기
        double dResult = a / 4.0;

        System.out.println("iResult = " + iResult);
        System.out.println("dResult = " + dResult);

    }
}
