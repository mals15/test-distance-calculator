package magenta.datasource.testdistancecalculator.service.xml;

import magenta.datasource.testdistancecalculator.dto.DistanceDTO;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

@Service
public class XmlService {

    List<DistanceDTO> listDistanceDTO;

    DistanceDTO distanceDTO;

    public List<DistanceDTO> parseDistanceFromXml(Document doc) {

        try{
            doc.getDocumentElement().normalize();

            distanceDTO = new DistanceDTO();
            NodeList nodeList = doc.getElementsByTagName("distance");
            List<DistanceDTO> listDistanceDTO = new ArrayList<>();

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) node;
                    distanceDTO = new DistanceDTO(
                            elem.getElementsByTagName("first_name").item(0).getTextContent(),
                            elem.getElementsByTagName("last_name").item(0).getTextContent(),
                            elem.getElementsByTagName("distance").item(0).getTextContent()
                    );
                    listDistanceDTO.add(distanceDTO);
                }
            }
            return listDistanceDTO;


        } catch(Exception e) {
                System.out.println(e.toString());
        }
        return listDistanceDTO;
    }



}
