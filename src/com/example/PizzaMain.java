package com.example;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

public class PizzaMain {

    public static void main(String[] args) {
        printMenu();
    }


    public static void printMenu() {
        PizzaKitchen pizzaKitchen = new PizzaKitchen();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n Choose : order or quit");
            String command = scanner.nextLine().trim();
            if (command.equals("order")) {
                System.out.print("Enter name: ");
                String customerName = scanner.nextLine();
                CompletableFuture.supplyAsync(() -> {
                    System.out.printf("\n Preparing pizza for " + customerName);
                    return pizzaKitchen.preparePizza();
                }).thenApplyAsync((pizza) -> System.out.printf("\n Pizza is ready for " + customerName));
            } else if (command.equals("quit")) {
                break;
            } else {
                System.out.println("Invalid command");
            }
        }
        scanner.close();
    }
}
