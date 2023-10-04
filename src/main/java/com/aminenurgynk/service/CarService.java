package com.aminenurgynk.service;

import com.aminenurgynk.model.Car;
import com.aminenurgynk.repository.CarRepository;
import com.aminenurgynk.untility.HibernateUtility;
import com.aminenurgynk.untility.ICrud;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class CarService implements ICrud<Car> {

    private CarRepository carRepository;

    public CarService() {
        this.carRepository = new CarRepository();
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car update(Car car) {
        return carRepository.update(car);
    }

    @Override
    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Car findById(Long id) {
        return carRepository.findById(id);
    }

    public List<Car> carsRent(){return carRepository.carsRent();}

    public List<Car> carsAvailable(){ return carRepository.carsAvailable();}

    public List<Car> findRentedCarByCustomerId(long id){ return carRepository.findRentedCarByCustomerId(id);}
}
