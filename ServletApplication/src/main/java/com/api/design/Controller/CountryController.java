package com.api.design.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.api.design.Entity.Country;
import com.api.design.Service.CountryService;
@Controller
public class CountryController {
    @Autowired
    CountryService service;

    @GetMapping("/mycountry")
    public String showNewCountryForm(Model model) {
        model.addAttribute("country", new Country());
        return "country";
    }
    @PostMapping("/countries")
    public String addCountry(@ModelAttribute("country") Country country) {
         service.saveCountry(country);
         return "AddedPage";
    }
}
