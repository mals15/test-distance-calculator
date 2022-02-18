package magenta.datasource.testdistancecalculator.controller;

import lombok.RequiredArgsConstructor;
import magenta.datasource.testdistancecalculator.dto.DistanceDTO;
import magenta.datasource.testdistancecalculator.service.xml.XmlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
@RequiredArgsConstructor
public class UploadDataController {

    @GetMapping("/upload/xml")
    public String uploadXml() {
        return "index";
    }

//    consumes = { MediaType.APPLICATION_XML_VALUE,
//   produces         MediaType.APPLICATION_JSON_VALUE }
    @ResponseBody
    @PostMapping(value = "/upload/xml",  consumes = { MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> uploadXml(@RequestParam MultipartFile file) throws IOException {
        try {
            InputStream is = file.getInputStream();
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);

            System.out.println(doc.toString());
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
