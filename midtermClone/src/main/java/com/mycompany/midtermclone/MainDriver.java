/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.midtermclone;

/**
 *
 * @author orlan
 */
import java.util.Scanner;
    
public class MainDriver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the permit number: ");
        String permitNumber = scanner.nextLine();

        System.out.print("Enter the permit category: ");
        String permitCategory = scanner.nextLine();

        BuildingPermit newPermit = new BuildingPermit(permitNumber, permitCategory);

        String[] permits = newPermit.getPermits();
        String[] categories = newPermit.getCategories();

        boolean categoryMatch = false;
        for (int i = 0; i < permits.length; i++) {
            if (permits[i].equals(permitNumber) && categories[i].equals(permitCategory)) {
                categoryMatch = true;
                break;
            }
        }

        if (categoryMatch) {
            System.out.println("Building permit created successfully!");
        } else {
            System.out.println("Invalid permit.");
        }
    }
}
