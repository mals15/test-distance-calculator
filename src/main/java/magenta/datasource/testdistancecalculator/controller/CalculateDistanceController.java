package magenta.datasource.testdistancecalculator.controller;

import lombok.RequiredArgsConstructor;
import magenta.datasource.testdistancecalculator.dto.RequestCalcDistanceDTO;
import magenta.datasource.testdistancecalculator.dto.ResponseCalcDistanceDTO;
import magenta.datasource.testdistancecalculator.service.CalcDistanceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CalculateDistanceController {

    private final CalcDistanceService calcDistanceService;

    @PostMapping("/calculate/distance")
    public ResponseCalcDistanceDTO calcDistance(@RequestBody RequestCalcDistanceDTO requestCalcDistanceDTO) {
        return calcDistanceService.calcDistance(requestCalcDistanceDTO);
    }
}
