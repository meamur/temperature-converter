package com.example.converter.controller;

import com.example.converter.model.TemperatureForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TemperatureController {

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("temperatureForm", new TemperatureForm());
        return "index";
    }

    @PostMapping("/convert")
    public String convertTemperature(@ModelAttribute TemperatureForm form, Model model) {
        double celsius = form.getCelsius();
        double fahrenheit = (celsius * 9/5) + 32;
        model.addAttribute("fahrenheit", fahrenheit);
        return "result";
    }
}
