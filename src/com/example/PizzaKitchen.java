package com.example;

import java.util.concurrent.TimeUnit;

public class PizzaKitchen {

    public String preparePizza() {
        try {
            TimeUnit.SECONDS.sleep(10); // simulam timpul de gatit pizza
            return "Pizza";
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
