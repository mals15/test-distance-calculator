package magenta.datasource.testdistancecalculator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class RequestCalcDistanceDTO {

    private final String calcType;
    private final String fromCity;
    private final String toCity;

    public RequestCalcDistanceDTO(@JsonProperty("CalcType") String calcType,
                                  @JsonProperty("fromCity") String fromCity,
                                  @JsonProperty("toCity") String toCity) {
        this.calcType = calcType;
        this.fromCity = fromCity;
        this.toCity = toCity;
    }
}
