package magenta.datasource.testdistancecalculator.service.impl;

import lombok.RequiredArgsConstructor;
import magenta.datasource.testdistancecalculator.CalcMethod;
import magenta.datasource.testdistancecalculator.domain.City;
import magenta.datasource.testdistancecalculator.dto.RequestCalcDistanceDTO;
import magenta.datasource.testdistancecalculator.dto.ResponseCalcDistanceDTO;
import magenta.datasource.testdistancecalculator.repository.CityRepository;
import magenta.datasource.testdistancecalculator.repository.DistanceRepository;
import magenta.datasource.testdistancecalculator.service.CalcDistanceService;
import magenta.datasource.testdistancecalculator.service.mapper.ResponseCalcDistanceMapper;
import magenta.datasource.testdistancecalculator.service.util.CalcCrowflight;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalcDistanceServiceImpl implements CalcDistanceService {

    private final CityRepository cityRepository;
    private final DistanceRepository distanceRepository;
    private final ResponseCalcDistanceMapper responseCalcDistanceMapper;
    private final CalcCrowflight calcCrowflight;

    @Override
    public ResponseCalcDistanceDTO calcDistance(RequestCalcDistanceDTO requestCalcDistanceDTO) {
        switch (requestCalcDistanceDTO.getCalcType()) {
            case CalcMethod.CROWFLIGHT:
                return crowflightMethod(requestCalcDistanceDTO);

            case CalcMethod.DISTANCE_MATRIX:
                return distanceMatrixMethod(requestCalcDistanceDTO);

            case CalcMethod.ALL:
                return allMethod(requestCalcDistanceDTO);

            default:
                throw new IllegalArgumentException("Неподдерживаемый тип метода подчета: " + requestCalcDistanceDTO.getCalcType());
        }
    }

    private ResponseCalcDistanceDTO crowflightMethod(RequestCalcDistanceDTO requestCalcDistanceDTO) {
        City fromCity = cityRepository.findCityByName(requestCalcDistanceDTO.getFromCity());
        City toCity = cityRepository.findCityByName(requestCalcDistanceDTO.getToCity());
        return responseCalcDistanceMapper.crowflightMethod(calcCrowflight.calcDistance(fromCity,toCity));
    }

    private ResponseCalcDistanceDTO distanceMatrixMethod(RequestCalcDistanceDTO requestCalcDistanceDTO) {
        return responseCalcDistanceMapper.distanceMatrixMethod(distanceRepository.findDistanceByFromCityAndToCity(
                requestCalcDistanceDTO.getFromCity(),
                requestCalcDistanceDTO.getToCity()));
    }

    private ResponseCalcDistanceDTO allMethod(RequestCalcDistanceDTO requestCalcDistanceDTO) {
        City fromCity = cityRepository.findCityByName(requestCalcDistanceDTO.getFromCity());
        City toCity = cityRepository.findCityByName(requestCalcDistanceDTO.getToCity());

        return responseCalcDistanceMapper.allMethod(calcCrowflight.calcDistance(fromCity,toCity),
                distanceRepository.findDistanceByFromCityAndToCity(
                requestCalcDistanceDTO.getFromCity(),
                requestCalcDistanceDTO.getToCity()));
    }
}
