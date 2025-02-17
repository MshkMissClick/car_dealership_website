package com.example.car_dealersip_website;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

//Get запрос
@RestController
@RequestMapping("/cars")
public class CarController {

    @GetMapping
    public Map<String, String> getCarsByQuery(@RequestParam(required = false) String brand,
                                              @RequestParam(required = false) String color) {
        return Map.of(
                "brand", brand != null ? brand : "any",
                "color", color != null ? color : "any"
        );
    }

    @GetMapping("/{brand}")
    public Map<String, String> getCarByBrand(@PathVariable String brand) {
        return Map.of("brand", brand, "message", "Car details for " + brand);
    }

}
