package co.rmgs.workshop.rest;

import co.rmgs.workshop.entity.CountryDTO;
import co.rmgs.workshop.entity.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryResource {

    @Autowired
    CountryService countryService;

    @GetMapping("/{code}")
    public CountryDTO getCountry(@PathVariable String code) {
        return countryService.getCountry(code);
    }
}
