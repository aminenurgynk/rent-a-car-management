package com.aminenurgynk.controller;

import com.aminenurgynk.model.Car;
import com.aminenurgynk.service.CarService;
import com.aminenurgynk.untility.ICrud;

import java.util.List;
import java.util.Optional;

public class CarController implements ICrud<Car> {

    private CarService carService;

    public CarController() {
        this.carService = new CarService();
    }

    @Override
    public Car save(Car car) {
        return carService.save(car);
    }

    @Override
    public Car update(Car car) {
        return carService.update(car);
    }

    @Override
    public void deleteById(Long id) {
        carService.deleteById(id);
    }

    @Override
    public List<Car> findAll() {
        return carService.findAll();
    }

    @Override
    public Car findById(Long id) {
        return carService.findById(id);
    }

    public List<Car> carsRent(){return carService.carsRent();}
    public List<Car> carsAvailable(){ return carService.carsAvailable();}

    public List<Car> findRentedCarByCustomerId(long id){ return carService.findRentedCarByCustomerId(id);}
}
