package com.aminenurgynk.untility;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

public class Utility {

    static Scanner scanner = new Scanner(System.in);

    public static int getInteger(String query) {

        boolean check = false;
        int index = 0;
        do {
            System.out.println(query);
            try {
                index = scanner.nextInt();
                check = false;
            } catch (Exception e) {
                System.out.println(e.toString() + ": please enter a numerical value");
                check = true;
            } finally {
                scanner.nextLine();
            }

        } while (check);
        return index;
    }

    public static double getDouble(String query) {

        boolean check = false;
        double index = 0;
        do {
            System.out.println(query);
            try {
                index = Double.parseDouble(scanner.nextLine());
                check = false;
            } catch (Exception e) {
                System.out.println(e.toString() + ": please enter a numerical value");
                check = true;
            }

        } while (check);
        return index;
    }

    public static long getLong(String query) {
        boolean check = false;
        long index = 0;
        do {
            System.out.println(query);
            try {
                index = Long.parseLong(scanner.nextLine());
                check = false;
            } catch (Exception e) {
                System.out.println(e.toString() + ": please enter a numerical value");
                check = true;
            }
        } while (check);
        return index;
    }

    public static String getString (String query) {
        System.out.println(query);
        return scanner.nextLine();
    }

    public static LocalDate getDateString(String query) {
        boolean check = false;
        LocalDate date = null;
        do {
            try {
                System.out.println(query);
                date = LocalDate.parse(scanner.nextLine());
                check = false;
            } catch (Exception e) {
                System.out.println(e.toString() + ": please enter a date (YYYY-MM-DD)");
                check = true;
            }

        } while (check);

        return date;
    }


}
