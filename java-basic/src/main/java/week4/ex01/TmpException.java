package week4.ex01;

public class TmpException {
    public static void main(String[] args) {
        TmpClass tmpClass = new TmpClass();

        try {
            tmpClass.exMethod();
        } catch (BadException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("finally");
        }
    }
}
