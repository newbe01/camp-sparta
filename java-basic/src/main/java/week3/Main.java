package week3;

public class Main {
    public static void main(String[] args) {
//        객체 생성, 객체배열 생성
//        Car car1 = new Car();
//        Car car2 = new Car();
//
//        System.out.println("car1 = " + car1);
//
//
//        Car[] carArray = new Car[3];
//        Car car3 = new Car();
//        car3.changeGear('P');
//        carArray[0] = car3;
//
//        Car car4 = new Car();
//        car4.changeGear('N');
//        carArray[1] = car4;
//
//        Car car5 = new Car();
//        car5.changeGear('D');
//        carArray[2] = car5;
//
//        for (Car car : carArray) {
//            System.out.println("car.gear = " + car.gear);
//        }

//        초기값, 기본값 확인
        Car car = new Car();
        System.out.println("car.model = " + car.model);
        System.out.println("car.color = " + car.color);
        System.out.println();

        System.out.println("car.speed = " + car.speed);
        System.out.println("car.gear = " + car.gear);
        System.out.println("car.lights = " + car.lights);
        System.out.println();

        System.out.println("car.tire = " + car.tire);
        System.out.println("car.door = " + car.door);
        System.out.println();

//        필드 사용
        car.color = "blue";
        car.speed = 100;
        car.lights = false;

        System.out.println("car.color = " + car.color);
        System.out.println("car.speed = " + car.speed);
        System.out.println("car.lights = " + car.lights);
        System.out.println();

//        call method, save return
        double speed = car.gasPedal(100, 'D');
        System.out.println("speed = " + speed);
        boolean lights = car.onOffLight();
        System.out.println("lights = " + lights);
        System.out.println("car.gear = " + car.gear);
        System.out.println();

        car.carSpeeds(100.0, 80.0);
        System.out.println();
        car.carSpeeds(100.0, 80.0, 150);

    }
}
