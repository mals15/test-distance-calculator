package magenta.datasource.testdistancecalculator.service;

import magenta.datasource.testdistancecalculator.dto.RequestCalcDistanceDTO;
import magenta.datasource.testdistancecalculator.dto.ResponseCalcDistanceDTO;

public interface CalcDistanceService {

    ResponseCalcDistanceDTO calcDistance(RequestCalcDistanceDTO RequestCalcDistanceDTO);
}
