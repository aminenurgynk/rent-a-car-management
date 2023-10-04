package com.aminenurgynk.service;

import com.aminenurgynk.model.Rent;
import com.aminenurgynk.repository.RentRepository;
import com.aminenurgynk.untility.ICrud;

import java.util.List;
import java.util.Optional;

public class RentService implements ICrud<Rent> {

    private RentRepository rentRepository;

    public RentService() {
        this.rentRepository = new RentRepository();
    }

    @Override
    public Rent save(Rent rent) {
        return rentRepository.save(rent);
    }

    @Override
    public Rent update(Rent rent) {
        return rentRepository.update(rent);
    }

    @Override
    public void deleteById(Long id) {
        rentRepository.deleteById(id);
    }

    @Override
    public List<Rent> findAll() {
        return rentRepository.findAll();
    }

    @Override
    public Rent findById(Long id) {
        return rentRepository.findById(id);
    }


}
