package magenta.datasource.testdistancecalculator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "distance_between_city")
public class DistanceDTO {

    @XmlElement(name = "from_city")
    private String fromCity;
    @XmlElement(name = "to_city")
    private String toCity;
    @XmlElement(name = "distance")
    private String distance;

}
