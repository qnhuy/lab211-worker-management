package gui;

import controller.Management;
import validation.Validation;

import java.util.Scanner;

public class Menu {
    private static String[] opt = {
            "Add Worker",
            "Up Salary",
            "Down Salary",
            "Display Information Salary",
            "Exit"
    };

    private static int getChoice() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < opt.length; i++) {
            System.out.println((i + 1) + ". " + opt[i]);
        }

        return Validation.getInt("Your choice: ", 1, opt.length);
    }

    public static void displayMenu() {
        Management m = new Management();
        int choice;

        do {
            System.out.println("=========Worker Management=========");
            choice = getChoice();

            switch (choice) {
                case 1:
                    m.addWorker();
                    break;
                case 2:
                    m.updateSalary(1);
                    break;
                case 3:
                    m.updateSalary(2);
                    break;
                case 4:
                    m.getInformation();
                    break;
                case 5:
                    m.displayAll();
                    break;
                case 6:
                    m.displayAll();
                    break;
            }
        } while (choice != opt.length);
    }
}
