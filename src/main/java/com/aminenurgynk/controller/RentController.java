package com.aminenurgynk.controller;

import com.aminenurgynk.model.Rent;
import com.aminenurgynk.service.RentService;
import com.aminenurgynk.untility.ICrud;

import java.util.List;
import java.util.Optional;

public class RentController implements ICrud<Rent> {

    private RentService rentService;

    public RentController() {
        this.rentService = new RentService();
    }

    @Override
    public Rent save(Rent rent) {
        return rentService.save(rent);
    }

    @Override
    public Rent update(Rent rent) {
        return rentService.update(rent);
    }

    @Override
    public void deleteById(Long id) {
        rentService.deleteById(id);
    }

    @Override
    public List<Rent> findAll() {
        return rentService.findAll();
    }

    @Override
    public Rent findById(Long id) {
        return rentService.findById(id);
    }
}
