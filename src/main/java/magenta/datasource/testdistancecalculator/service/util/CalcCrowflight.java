package magenta.datasource.testdistancecalculator.service.util;

import magenta.datasource.testdistancecalculator.domain.City;
import org.springframework.stereotype.Component;


@Component
public class CalcCrowflight {



    public double calcDistance(City fromCity, City toCity) {

        InnerCityCoordinates fromInnerCity = new InnerCityCoordinates();
        InnerCityCoordinates toInnerCity = new InnerCityCoordinates();

        fromInnerCity.latitude = fromCity.getLatitude();
        fromInnerCity.longitude = fromCity.getLongitude();
        toInnerCity.latitude = toCity.getLatitude();
        toInnerCity.longitude = toCity.getLongitude();

        return 111.2 * Math.sqrt(
                        (fromInnerCity.longitude - toInnerCity.longitude)*
                                (fromInnerCity.longitude - toInnerCity.longitude)+
                                (fromInnerCity.latitude - toInnerCity.latitude)
                        *Math.cos(Math.PI*fromInnerCity.longitude/180)*
                                        (fromInnerCity.latitude - toInnerCity.latitude)
                        *Math.cos(Math.PI*fromInnerCity.longitude/180));
    }

    class InnerCityCoordinates {
        double latitude;
        double longitude;


    }


}

