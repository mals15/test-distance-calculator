package magenta.datasource.testdistancecalculator.controller;

import lombok.RequiredArgsConstructor;
import magenta.datasource.testdistancecalculator.dto.CityDTO;
import magenta.datasource.testdistancecalculator.service.CityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping("/city/all")
    public List<CityDTO> allCity() {
        return cityService.getAllCityIdAndName();
    }
}
