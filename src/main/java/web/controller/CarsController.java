package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.Service.CarServiceImpl;

@Controller
@RequestMapping("/cars")
public class CarsController {
    private final CarServiceImpl carService;

    @Autowired
    public CarsController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping
    public String countCars (Model model, @RequestParam(value = "count", defaultValue = "5") int count) {
        model.addAttribute("cars", carService.showCountCar(count));
        return "cars/index";
    }

    @GetMapping("/model")
    public String modelCars(Model model) {
        return "cars/page";
    }
}
