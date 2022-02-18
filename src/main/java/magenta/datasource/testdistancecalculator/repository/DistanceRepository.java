package magenta.datasource.testdistancecalculator.repository;

import magenta.datasource.testdistancecalculator.domain.Distance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistanceRepository extends CrudRepository<Distance, Long> {

    Distance findDistanceByFromCityAndToCity(String fromCity, String toCity);
}
