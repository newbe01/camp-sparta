package week2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Week2HW {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();

        while (true) {
            String str = sc.nextLine();
            if (str.equals("끝")) {
                break;
            }

            list.add(str);
        }

        System.out.println("[list]로 저장된 " + list.get(0));

        for (int i = 1; i < list.size(); i++) {
            System.out.println(i + list.get(i));
        }
    }
}
