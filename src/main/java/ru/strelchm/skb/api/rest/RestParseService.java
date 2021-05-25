package ru.strelchm.skb.api.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.strelchm.skb.ServiceAnswer;

import java.util.List;

@Service
public class RestParseService {

    public static final int TIMEOUT = 5000;

    public ServiceAnswer<List<String>, Integer> restCall(int id) throws JsonProcessingException {
        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setConnectionRequestTimeout(TIMEOUT);
        httpRequestFactory.setConnectTimeout(TIMEOUT);
        httpRequestFactory.setReadTimeout(TIMEOUT);

        RestTemplate restTemplate =  new RestTemplate(httpRequestFactory);
        String fooResourceUrl = "http://localhost:9080/api/v1/phones/";
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl + id, String.class);

        response.getStatusCode();
        ObjectMapper mapper = new ObjectMapper();
//        JsonNode root = mapper.readTree(response.getBody());
//        root.get("").a

        ResponseEntity<PhonesResponse> phonesResponse = restTemplate.getForEntity(fooResourceUrl + id, PhonesResponse.class);
        int respStatus = 0;
        HttpStatus status = phonesResponse.getStatusCode();
        if(status != HttpStatus.OK) {
            respStatus = 2;
        }

        return new ServiceAnswer(phonesResponse.getBody().getPhones(), respStatus);
    }
}
