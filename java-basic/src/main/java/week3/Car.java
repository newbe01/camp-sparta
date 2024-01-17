package week3;

public class Car {

    // 고유데이터
    String company; // 회사
    String model = "GV80";   // 모델
    String color;   // 색상
    double price;   // 가격

    // 상태데이터
    double speed;   // 속도
    char gear;      // 기어상태
    boolean lights = true; // 조명 상태

    // 객체데이터
    Tire tire = new Tire();
    Door door;
    Handle handle;

    // constructor : 객체가 생성될때 필수값과, 실행로직을 정의
    public Car() {
        System.out.println("call Car");
    }

    //method

    /**
     * p : km/h
     * p : gear(char)
     * @return speed
     */
    double gasPedal(double kmh, char type) {
        changeGear(type);
        speed = kmh;
        return speed;
    }

    /**
     * p : X
     * @return speed
     */
    double brakePedal() {
        speed = 0;
        return speed;
    }

    /**
     * p : gear(char)
     * @return gear
     */
    char changeGear(char type) {
        gear = type;
        return gear;
    }

    /**
     * p : X
     * @return lights(boolean)
     */
    boolean onOffLight() {
        lights = !lights;
        return lights;
    }

    /**
     * p : X
     * r : X
     */
    void horn() {
        System.out.println("Car.horn");
    }

    // car speed

    /**
     *
     */
    void carSpeeds(double... speeds) {
        for (double v : speeds) {
            System.out.println("v = " + v);
        }
    }
}
