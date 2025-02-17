package com.example.car_dealersip_website.service;

import com.example.car_dealersip_website.model.Car;
import com.example.car_dealersip_website.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public List<Car> getCarsByFilters(String brand, String color) {
        return carRepository.findByFilters(brand, color);
    }

    public Optional<Car> getCarById(int id) {
        return carRepository.findById(id);
    }
}
