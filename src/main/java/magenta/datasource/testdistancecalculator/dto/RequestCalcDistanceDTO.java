package magenta.datasource.testdistancecalculator.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class RequestCalcDistanceDTO {

    private final String CalcType;
    private final String fromCity;
    private final String toCity;

    public RequestCalcDistanceDTO(@JsonProperty("CalcType") String CalcType,
                                  @JsonProperty("fromCity") String fromCity,
                                  @JsonProperty("toCity") String toCity) {
        this.CalcType = CalcType;
        this.fromCity = fromCity;
        this.toCity = toCity;
    }
}
