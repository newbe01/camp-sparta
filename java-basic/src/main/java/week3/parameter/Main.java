package week3.parameter;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();

        // 기본형
        char type = 'D';
        car.brakePedal(type);

        System.out.println("type = " + type);
        System.out.println("car.gear = " + car.gear);
        System.out.println();

        Tire tire = new Tire();
        tire.company = "금호";

        Tire CarInstanceTire = car.setTire(tire);
        System.out.println("tire.company = " + tire.company);
        System.out.println("CarInstanceTire.company = " + CarInstanceTire.company);
        
    }
}
