package week4.ex01;

public class TmpClass {

    private final boolean just = true;

    public void exMethod() throws BadException {
        if (just) {
            throw new BadException();
        }
    }

}
