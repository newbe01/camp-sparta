package week1;

import java.util.Scanner;

public class Ascii {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int asciiNum = sc.nextInt();
//        char ch = (char) asciiNum;
//        System.out.println("ch = " + ch);

        char letter = sc.nextLine().charAt(0);
        int asciiNum = letter;

        System.out.println("asciiNum = " + asciiNum);
    }
}
