package magenta.datasource.testdistancecalculator.repository;

import magenta.datasource.testdistancecalculator.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    City findCityByName(String cityName);

}
