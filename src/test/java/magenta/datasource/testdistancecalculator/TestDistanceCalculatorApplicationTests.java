package magenta.datasource.testdistancecalculator;

import magenta.datasource.testdistancecalculator.domain.Distance;
import magenta.datasource.testdistancecalculator.repository.DistanceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class TestDistanceCalculatorApplicationTests {

	@Autowired
	private DistanceRepository distanceRepository;

	@Test
	void contextLoads() {
		System.out.print(CalcMethod.CROWFLIGHT);
	}

}
