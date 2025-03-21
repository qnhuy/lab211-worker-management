package validation;

import model.Worker;

import java.util.List;
import java.util.Scanner;

public class Validation {
    private static Scanner sc = new Scanner(System.in);

    public static int getInt(String mess, int min, int max) {
        while (true) {
            System.out.print(mess);
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n >= min && n <= max) {
                    return n;
                } else {
                    System.err.println("Out of bound. Please enter a number between " + min + " and " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.err.println("Wrong format. Please enter an integer!");
            }
        }
    }

    public static double getDouble(String mess, double min, double max) {
        while (true) {
            System.out.print(mess);
            try {
                double n = Double.parseDouble(sc.nextLine());
                if (n >= min && n <= max) {
                    return n;
                } else {
                    System.err.println("Out of bound. Please enter number that between " + min + " and " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.err.println("Wrong format. Please enter an integer!");
            }
        }
    }

    public static String getString(String mess, String err) {
        while (true) {
            System.out.print(mess);
            String s = sc.nextLine();
            if (!s.isEmpty()) {
                return s;
            }
            System.err.println(err);
        }
    }

    public static boolean getYN(String mess) {
        while (true) {
            System.out.println(mess);
            String s = sc.nextLine();
            if (s.equalsIgnoreCase("y")) {
                return true;
            } else if (s.equalsIgnoreCase("n")) {
                return false;
            }
            System.err.println("Only accept Y/N!");
        }
    }

    public static String getCode(String mess, String err, List<Worker> wList, int codeMode) {
        String s;
        while (true) {
            System.out.print(mess);
            s = sc.nextLine();
            //mode 1: input - id not exist
            //mode 2: update - id must exist
            if (!s.isEmpty()) {
                if ((codeMode == 1 && checkWorker(s, wList) == null)
                        || (codeMode == 2 && checkWorker(s, wList) != null)) {
                    break;
                } else {
                    System.err.println(err);
                }
            }
        }
        return s;
    }

    public static Worker checkWorker(String id, List<Worker> wList) { //check id existed or not in database
        for (Worker w : wList) {
            if (w.getId().equals(id)) {
                return w;
            }
        }
        return null;
    }
}
