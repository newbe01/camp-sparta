package week4.w04HW;

public class BadInputException extends Exception {

    public BadInputException(String type) {
        super("wrong type [" + type + "]");
    }
}
