package week3.w3HW;

public class Main {
    public static void main(String[] args) {
        Calculator c = new Calculator(new AddOperation());
        System.out.println(c.calculating(15, 20));

        c = new Calculator(new SubtractOperation());
        System.out.println(c.calculating(15, 20));

        c = new Calculator(new MultiplyOperation());
        System.out.println(c.calculating(15, 20));

        c = new Calculator(new DivideOperation());
        System.out.println(c.calculating(15, 20));
    }
}
