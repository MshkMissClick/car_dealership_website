package com.example.car_dealersip_website.repository;

import com.example.car_dealersip_website.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CarRepository {
    private final List<Car> cars = new ArrayList<>(List.of(
            new Car(1, "Toyota", "Red"),
            new Car(2, "BMW", "Black"),
            new Car(3, "Mercedes", "White")
    ));

    public List<Car> findAll() {
        return cars;
    }

    public List<Car> findByFilters(String brand, String color) {
        return cars.stream()
                .filter(car -> (brand == null || car.getBrand().equalsIgnoreCase(brand)) &&
                        (color == null || car.getColor().equalsIgnoreCase(color))).toList();
    }

    public Optional<Car> findById(int id) {
        return cars.stream()
                .filter(car -> car.getId() == id)
                .findFirst();
    }
}
