package ru.strelchm.skb.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.strelchm.skb.ServiceAnswer;
import ru.strelchm.skb.api.exc.BadRequestException;
import ru.strelchm.skb.api.exc.NotFoundException;
import ru.strelchm.skb.api.rest.RestParseService;
import ru.strelchm.skb.api.soap.SOAPConnector;
import ru.strelchm.skb.api.soap.generated.GetUserResponse;

import java.util.List;

/**
 * REST-контроллер для ресурсов "Тендер"
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/")
public class RestController {

    @Autowired
    private SOAPConnector soapConnector;
    @Autowired
    private RestParseService restParseService;

    @GetMapping("/user/{id}")
    public RestDto getTenderById(@PathVariable Integer id) throws JsonProcessingException {
        if (id == null) {
            throw new BadRequestException();
        }

        GetUserResponse soapResponse = soapConnector.callWebService(id);
        ServiceAnswer<List<String>, Integer> restResponse = restParseService.restCall(id);

        RestDto restDto = new RestDto();
        restDto.setCode(restResponse.getV());

        if(soapResponse != null) {
            restDto.setName(soapResponse.getUser().getFirstName() + " " + soapResponse.getUser().getLastName());
        }

        if (!restResponse.getT().isEmpty()) {
            restDto.setPhone(restResponse.getT().get(0));
        }

        return restDto;
    }
}
