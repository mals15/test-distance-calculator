package magenta.datasource.testdistancecalculator.service.mapper;

import magenta.datasource.testdistancecalculator.domain.City;
import magenta.datasource.testdistancecalculator.dto.CityDTO;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CityMapper {

    public CityDTO mapCityToCityDTO(City model) {
        return new CityDTO(
                model.getId(),
                model.getName()
        );
    }

    public List<CityDTO> mapCityToCityDTO(Collection<City> model) {
        return model.stream()
                .map(this::mapCityToCityDTO)
                .collect(Collectors.toList());
    }
}
