package week1;

public class Variable {
    public static void main(String[] args) {

        //기본형
        // boolean
        boolean flag = true;
        flag = false;
        final boolean finalFlag = false;
//        finalFlag = true; error

        // char
        char alphabet = 'a';
        char num = 2;
        char num2 = '2';

        // 정수형
        byte byteNum = 127;         // -128 ~ 127
        short shortNum = 32767;     // -32768 ~ 32767
        int intNum = 2147483647;    // -2147483648 ~ 2147483647
        long longNum = 2147483647L; // ~

        // 실수형
        float floatNum = 0.123F;
        double doubleNum = 0.12345;

        // 참조형
        // String
        String str = "Hello world";

        // 배열
        int[] arr = {1, 2, 3, 4, 5};

        // wrapper class
        int number = 21;
        Integer integerNum = number;

        int a = integerNum.intValue();
    }
}
