package com.sparta.springauth;

import com.sparta.springauth.food.Food;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BeanTest {

//    @Autowired
//    Food chicken;
//
//    @Autowired
//    Food pizza;

    @Qualifier("pizza")
    @Autowired
    Food food;

    @Test
    void callTest() {
//        pizza.eat();
//        chicken.eat();

        food.eat();
    }
}
