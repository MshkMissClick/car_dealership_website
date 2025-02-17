package com.example.car_dealership_website.controller;

import com.example.car_dealership_website.model.Car;
import com.example.car_dealership_website.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Get запрос
@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    // 1. GET /cars?brand=Toyota&color=Red (Query Parameters)
    @GetMapping
    public List<Car> getCarsByQuery(@RequestParam(required = false) String brand,
                                    @RequestParam(required = false) String color) {
        return carService.getCarsByFilters(brand, color);
    }

    // 2. GET /cars/{id} (Path Parameter)
    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable int id) {
        return carService.getCarById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
