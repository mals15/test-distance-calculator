package magenta.datasource.testdistancecalculator.service.impl;

import lombok.RequiredArgsConstructor;
import magenta.datasource.testdistancecalculator.domain.City;
import magenta.datasource.testdistancecalculator.dto.CityDTO;
import magenta.datasource.testdistancecalculator.repository.CityRepository;
import magenta.datasource.testdistancecalculator.service.CityService;
import magenta.datasource.testdistancecalculator.service.mapper.CityMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    @Override
    public List<CityDTO> getAllCityIdAndName() {
        List<City> cities = cityRepository.findAll();
        return cityMapper.mapCityToCityDTO(cities);
    }
}
