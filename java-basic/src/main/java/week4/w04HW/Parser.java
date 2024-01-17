package week4.w04HW;

import java.util.regex.Pattern;

public class Parser {
    private static final String OPERATION_REG = "[+\\-*/]";
    private static final String NUMBER_REG = "^[0-9]*$";

    private final Calculator calculator = new Calculator();

    public void parseFirstNum(String firstInput) throws BadInputException {
        boolean matches = Pattern.matches(NUMBER_REG, firstInput);
        if (!matches) {
            throw new BadInputException("숫자아님");
        }

        calculator.setFirstNumber(Integer.parseInt(firstInput));
    }

    public void parseSecondNum(String secondInput) throws BadInputException {
        boolean matches = Pattern.matches(NUMBER_REG, secondInput);
        if (!matches) {
            throw new BadInputException("숫자아님");
        }
        calculator.setSecondNumber(Integer.parseInt(secondInput));
    }

    public void parseOperator(String operationInput) throws BadInputException {
        boolean matches = Pattern.matches(OPERATION_REG, operationInput);
        if (!matches) {
            throw new BadInputException("잘못된 기호");
        }

        if (operationInput.equals("+")) {
            calculator.setOperation(new AddOperation());
        } else if (operationInput.equals("-")) {
            calculator.setOperation(new SubtractOperation());
        } else if (operationInput.equals("*")) {
            calculator.setOperation(new MultiplyOperation());
        } else if (operationInput.equals("/")) {
            calculator.setOperation(new DivideOperation());
        }
    }

    public double executeCalculator() {
        return calculator.calculate();
    }

}
