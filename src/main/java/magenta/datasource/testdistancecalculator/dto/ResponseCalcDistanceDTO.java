package magenta.datasource.testdistancecalculator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
public class ResponseCalcDistanceDTO {

    private Map<String, Double> resultCalc;


//    private double crowflight;
//    private double distanceMatrix;


}
