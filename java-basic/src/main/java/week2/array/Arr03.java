package week2.array;

public class Arr03 {
    public static void main(String[] args) {

        // String utils
        String str = "ABCD";

        int len = str.length();
        System.out.println("len = " + len);

        char ch = str.charAt(1);
        System.out.println("ch = " + ch);

        String substr = str.substring(0, 3);
        System.out.println("substr = " + substr);

        boolean strEq = str.equals("ABCD");
        System.out.println("strEq = " + strEq);

        char[] chArr = str.toCharArray();
        for (char c : chArr) {
            System.out.println("c = " + c);
        }

        String chArrToStr = new String(chArr);
        System.out.println("chArrToStr = " + chArrToStr);
    }
}
