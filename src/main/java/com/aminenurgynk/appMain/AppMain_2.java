package com.aminenurgynk.appMain;

import com.aminenurgynk.controller.CustomerController;
import com.aminenurgynk.model.Address;
import com.aminenurgynk.model.Customer;
import com.aminenurgynk.repository.CarRepository;
import com.aminenurgynk.repository.CustomerRepository;
import com.aminenurgynk.untility.AppMenu;


public class AppMain_2 {

    public static void main(String[] args) {
/*
        CarController carController = new CarController();
        CustomerController customerController = new CustomerController();
        RentController rentController = new RentController();

*/
/*        CustomerDetail customerDetail1 = CustomerDetail.builder().phone_number(56635).build();
        CustomerDetail customerDetail2 = CustomerDetail.builder().phone_number(56635).build();
        CustomerDetail customerDetail3 = CustomerDetail.builder().phone_number(56635).build();*//*



        Customer customer1 = Customer.builder().lastname("candan")
                .address(Address.builder().city("dsfsd").build()).firstname("Gell Gell").build();
        Customer customer2 = Customer.builder().lastname("baldan")
                .address(Address.builder().city("dsfsd").build()).firstname("Gell Gell").build();
        Customer customer3 = Customer.builder().lastname("kandan")
                .address(Address.builder().city("dsfsd").build()).firstname("Gell Gell").build();

        Car car1 = Car.builder().name("MERCEDES").status(EStatus.AVAILABLE).build();
        Car car2 = Car.builder().name("BMW").status(EStatus.AVAILABLE).build();
        Car car3 = Car.builder().name("JAGUAR").status(EStatus.AVAILABLE).build();
        Car car4 = Car.builder().name("VOSVOS :)").status(EStatus.AVAILABLE).build();


        Rent rent1 = Rent.builder().car(car1).build();
        Rent rent2 = Rent.builder().car(car2).build();
        Rent rent3 = Rent.builder().car(car3).build();

        car1.setCustomer(customer3);
        car2.setCustomer(customer3);
        car3.setCustomer(customer2);

        car1.setRentList(List.of(rent1));

        customerController.save(customer1);
        customerController.save(customer2);
        customerController.save(customer3);

        carController.save(car1);
        carController.save(car2);
        carController.save(car3);

        rentController.save(rent1);
        rentController.save(rent2);
        rentController.save(rent3);
*/

/*        CustomerController customerController = new CustomerController();
        Customer customer1 = Customer.builder().id(1).firstname("Ceyda")
                .lastname("Kasabali").phone_number(589632)
                .address(Address.builder().city("Turkiye").country("Ankara").build()).build();
        Customer customer2 = Customer.builder().id(2).firstname("Gizem")
                .lastname("Kuscuoglu").phone_number(589632)
                .address(Address.builder().city("Turkiye").country("Ankara").build()).build();
        Customer customer3 = Customer.builder().id(3).firstname("Caner")
                .lastname("Oksuz").phone_number(1325345)
                .address(Address.builder().city("Turkiye").country("Ankara").build()).build();
        Customer customer4 = Customer.builder().id(4).firstname("Mustafa")
                .lastname("Hoca").phone_number(98765)
                .address(Address.builder().city("Turkiye").country("Ankara").build()).build();
        Customer customer5 = Customer.builder().id(5).firstname("Mimar")
                .lastname("Hoca").phone_number(554632)
                .address(Address.builder().city("Turkiye").country("Ankara").build()).build();
        Customer customer6 = Customer.builder().id(6).firstname("Fatih")
                .lastname("Terim").phone_number(432432)
                .address(Address.builder().city("Turkiye").country("Ankara").build()).build();
        Customer customer7 = Customer.builder().id(7).firstname("Aminenur")
                .lastname("Goynuk").phone_number(432432)
                .address(Address.builder().city("Turkiye").country("Ankara").build()).build();
        customerController.update(customer1);
        customerController.update(customer2);
        customerController.update(customer3);
        customerController.update(customer4);
        customerController.update(customer5);
        customerController.update(customer6);
        customerController.update(customer7);*/


        AppMenu appMenu = new AppMenu();
        appMenu.mainMenuApp();


    }
}
