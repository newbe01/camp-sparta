package week1;

import java.util.Scanner;

public class week1HW {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1 = sc.nextLine();
        double str2 = sc.nextDouble();
        String str3 = sc.nextLine();
        String str4 = sc.nextLine();
        String str5 = sc.nextLine();
        String str6 = sc.nextLine();
        String str7 = sc.nextLine();
        String str8 = sc.nextLine();
        String str9 = sc.nextLine();
        String str0 = sc.nextLine();
        String strA = sc.nextLine();

        int star = (int) str2;
        System.out.println("[" + str1 +"]");
        System.out.println(star + "(" + (star/5.0) * 100 + ")");
        System.out.println(str3);
        System.out.println(str4);
        System.out.println(str5);
        System.out.println(str6);
        System.out.println(str7);
        System.out.println(str8);
        System.out.println(str9);
        System.out.println(str0);
        System.out.println(strA);
    }
}
