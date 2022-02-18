package magenta.datasource.testdistancecalculator.service;

import magenta.datasource.testdistancecalculator.dto.CityDTO;

import java.util.List;

public interface CityService {

    List<CityDTO> getAllCityIdAndName();
}
