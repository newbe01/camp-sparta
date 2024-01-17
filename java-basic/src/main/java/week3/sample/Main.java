package week3.sample;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.getNumber());
        System.out.println(main.getNumber());

    }

    // 메소드
    public int getNumber() {
        // 지역변수
        // 메소드가 실행될때 마다 생성되고 종료될때 소멸된다.
        int num = 1;
        num += 1;
        return num;
    }
}
