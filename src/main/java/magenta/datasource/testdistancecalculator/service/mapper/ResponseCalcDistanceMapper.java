package magenta.datasource.testdistancecalculator.service.mapper;

import magenta.datasource.testdistancecalculator.CalcMethod;
import magenta.datasource.testdistancecalculator.domain.Distance;
import magenta.datasource.testdistancecalculator.dto.ResponseCalcDistanceDTO;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ResponseCalcDistanceMapper {

    Map<String, Double> resultCalc = new HashMap<>();

    public ResponseCalcDistanceDTO crowflightMethod(double distance) {
        Double dDistance = distance;
        resultCalc.put(CalcMethod.CROWFLIGHT, dDistance);
        return new ResponseCalcDistanceDTO(resultCalc);
    }

    public ResponseCalcDistanceDTO distanceMatrixMethod(Distance model) {
        resultCalc.put(CalcMethod.DISTANCE_MATRIX, model.getDistance());
        return new ResponseCalcDistanceDTO(resultCalc);
    }

    public ResponseCalcDistanceDTO allMethod(double distance, Distance model) {
        Double dDistance = distance;
        resultCalc.put(CalcMethod.CROWFLIGHT, dDistance);
        resultCalc.put(CalcMethod.DISTANCE_MATRIX, model.getDistance());
        return new ResponseCalcDistanceDTO(resultCalc);
    }
}
