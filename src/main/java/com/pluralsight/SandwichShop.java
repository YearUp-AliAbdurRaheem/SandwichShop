package com.pluralsight;
import java.util.Scanner;

public class SandwichShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Asking user for sandwich type
        System.out.print("""
                Welcome to the YearUp Sandwich Shop!
                What sandwich would you like today?
                \t(1): Regular: base price $5.45
                \t(2):  Large:  base price $8.95\n>>>"""+' ');
        int sandwich = scanner.nextInt();

        // Asking user for age
        System.out.print("Enter your age:\n>>> ");
        int age = scanner.nextInt(); scanner.nextLine();

        // Asking user if loaded
        System.out.print("Would you like a \"loaded\" sandwich? (y/n)\n>>> ");
        String loaded = scanner.nextLine();

        boolean isLoaded = (loaded.equalsIgnoreCase("y") || loaded.equalsIgnoreCase("yes"));
        double standerdReg = 5.45; double loadedAddReg = 1.00;
        double standerdLrg = 8.95; double loadedAddLrg = 1.75;
        double regular = isLoaded ? 5.45 + 1.00 : standerdReg;
        double large = isLoaded ? 8.95 + 1.75 : standerdLrg;

        // calculating total
        double subtotal = sandwich == 1 ? regular : large;
        double discount = 0;
        if (age <= 17) {
            discount = 0.10;  // 10% student discount
        } else if (age >= 65) {
            discount = 0.20;  // 20% senior discount
        }

        double discountAmount = subtotal * discount;
        double total = subtotal - discountAmount;

        // Recipt
        System.out.printf("""
                ------Recipt------
                 %s Sandwich
                 Price     $%.2f%s
                 Subtotal: $%.2f
                 Discount: %.0f%%
                 Total:    $%.2f
                ------------------""",
                sandwich == 1 ? "Regular" : "Large",
                sandwich == 1 ? standerdReg : standerdLrg,
                isLoaded ? "\n Loaded   +$" + String.format("%.2f", (sandwich == 1 ? loadedAddReg : loadedAddLrg)) : "",
                subtotal,
                discount * 100,
                total);

    }
}
