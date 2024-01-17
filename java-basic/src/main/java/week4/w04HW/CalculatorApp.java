package week4.w04HW;

import java.util.Scanner;

public class CalculatorApp {

    public static boolean start() throws BadInputException {
        Parser parser = new Parser();
        Scanner sc = new Scanner(System.in);

        System.out.println("첫번째 숫자를 입력해주세요!");
        String firstInput = sc.nextLine();
        parser.parseFirstNum(firstInput);

        System.out.println("연산자를 입력해주세요!");
        String operator = sc.nextLine();
        parser.parseOperator(operator);

        System.out.println("두번째 숫자를 입력해주세요!");
        String secondNumber = sc.nextLine();
        parser.parseSecondNum(secondNumber);

        System.out.println("연산결과 : " + parser.executeCalculator());
        return true;
    }

}
