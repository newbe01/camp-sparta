package week4.w04HW;

public class Main {
    public static void main(String[] args) throws BadInputException {
        boolean calculateEnded = false;

        while (!calculateEnded) {
            try {
                calculateEnded = CalculatorApp.start();
            } catch (BadInputException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
