package week2.operator;

import java.util.Objects;
import java.util.Scanner;

public class W12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("A ::");
        String aHand = sc.nextLine();

        System.out.println("B ::");
        String bHand = sc.nextLine();

        if (Objects.equals(aHand, "가위")) {
            if (Objects.equals(bHand, "가위")) {
                System.out.println("draw");
            } else if (Objects.equals(bHand, "바위")) {
                System.out.println("B WIN");
            } else if (Objects.equals(bHand, "보")) {
                System.out.println("A WIN");
            } else {
                System.out.println("B ???");
            }
        } else if (Objects.equals(aHand, "바위")) {
            if (Objects.equals(bHand, "바위")) {
                System.out.println("draw");
            } else if (Objects.equals(bHand, "보")) {
                System.out.println("B WIN");
            } else if (Objects.equals(bHand, "가위")) {
                System.out.println("A WIN");
            } else {
                System.out.println("B ???");
            }
        } else if (Objects.equals(aHand, "보")) {
            if (Objects.equals(bHand, "보")) {
                System.out.println("draw");
            } else if (Objects.equals(bHand, "가위")) {
                System.out.println("B WIN");
            } else if (Objects.equals(bHand, "바위")) {
                System.out.println("A WIN");
            } else {
                System.out.println("B ???");
            }
        } else {
            System.out.println("A ???");
        }
    }
}
