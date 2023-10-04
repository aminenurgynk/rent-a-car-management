package com.aminenurgynk.untility;

import com.aminenurgynk.controller.CarController;
import com.aminenurgynk.controller.CustomerController;
import com.aminenurgynk.controller.RentController;
import com.aminenurgynk.model.Car;
import com.aminenurgynk.model.Customer;
import com.aminenurgynk.model.Rent;
import com.aminenurgynk.model.enums.EStatus;

import java.util.List;

public class AppMenu {

    static CarController carController = new CarController();
    static CustomerController customerController = new CustomerController();
    static RentController rentController = new RentController();

    public static void insertCar(){
        String brandOfCar = Utility.getString("Please enter the car' brand");
        String modelOfCar = Utility.getString("Please enter the car' model");
        Car car = Car.builder().brand(brandOfCar).model(modelOfCar).build();
        carController.save(car);
    }

    public static void searchCar(){
        System.out.println(carController.findAll());
        long id = Utility.getLong("Please choose the car, " +
                "and enter the id value of the car");
        if (carController.findById(id) == null){
            System.out.println("The searched car could not be found");
            mainMenuApp();
        }
        System.out.println(carController.findById(id));
    }
    public static void addCustomer(){
        String firstname = Utility.getString("Please enter your name");
        String lastname = Utility.getString("Please enter your lastname");
        Customer customer = Customer.builder().firstname(firstname).lastname(lastname).build();
        customerController.save(customer);
    }

    public static void rent(){
        carsAvailable();
        long id = Utility.getLong("Please enter the ID number of the car you want to rent.");
        Car car = carController.findById(id);
        car.setStatus(EStatus.RENTED);

/*        int index = Utility.getInteger("Please enter your customer information" +
              "\n" +
                "If you are a new customer ---> Press 1" +
                "\n" +
                "If you have an account --->  Press 2");
        if (index == 1) {
            addCustomer();
        }
        System.out.println(customerController.findAll());*/


        long id_customer = Utility.getLong("Please enter the ID of the person who wants to rent");

        Customer customer = customerController.findById(id_customer);
        System.out.println("Customer Information --> " + customer);

        Rent rent = Rent.builder().customer(customer).car(car).build();
        rentController.save(rent);
    }

    public static void carsRent(){
        List<Car> carList = carController.carsRent();
        carList.forEach(System.out::println);
    }
    public static void carsAvailable(){
        List<Car> carList = carController.carsAvailable();
        carList.forEach(System.out::println);
    }
    public static void findRentedCarByCustomerId(){
        System.out.println(customerController.findAll());
        long id = Utility.getLong("Please enter the ID number of the customer");
        List<Car> carList = carController.findRentedCarByCustomerId(id);
        carList.forEach(System.out::println);
    }

    public static void reportMenuApp(){
        reportMenu();
        int index = Utility.getInteger("Enter the number for your selection");

            switch (index){
                case 1:
                    carsRent();
                    reportMenuApp();
                    break;
                case 2:
                    carsAvailable();
                    reportMenuApp();
                    break;
                case 3:
                    findRentedCarByCustomerId();
                    reportMenuApp();
                    break;
                case 4:
                    System.out.println("Log out to Report Menu");
                    mainMenuApp();
                    break;
                default:
                    break;
            }

    }
    public static void reportMenu(){
        System.out.println("** REPORT MENU **" +
                "\n" +
                "1-) Which cars are currently rented?" +
                "\n" +
                "2-) Which cars are currently available?" +
                "\n" +
                "3-) The cars rented by the customer whose ID is given?" +
                "\n" +
                "4-) Log out to Report Menu");
    }

    public static void mainMenuApp(){
        int index = mainMenu();
        boolean check = true;
        do {
            switch (index){
                case 1:
                    insertCar();
                    mainMenuApp();
                    break;
                case 2:
                    searchCar();
                    mainMenuApp();
                    break;
                case 3:
                    addCustomer();
                    mainMenuApp();
                    break;

                case 4:
                    rent();
                    mainMenuApp();
                    break;
                case 5:
                    reportMenuApp();
                    mainMenuApp();
                    break;
                case 0:
                    System.out.println("LOG OUT...");
                    check = false;
                    break;

                default:
                    break;
            }
        }while (check);

    }

    public static int mainMenu(){
        System.out.println("**** RENT A CAR SYSTEM ****" +
                "\n" +
                "1-) Inserting the car" +
                "\n" +
                "2-) Searching the car" +
                "\n" +
                "3-) Adding Customer" +
                "\n" +
                "4-) Renting" +
                "\n" +
                "5-) Report" +
                "\n" +
                "0-) Log out");

        return Utility.getInteger("Enter the number for your selection");
    }
}
