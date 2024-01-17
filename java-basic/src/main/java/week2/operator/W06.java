package week2.operator;

public class W06 {
    public static void main(String[] args) {
        // ++, -- 주의사항
        int a = 10;
        int b = 10;
        int val = ++a + b--;
        System.out.println("val = " + val);
    }
}
