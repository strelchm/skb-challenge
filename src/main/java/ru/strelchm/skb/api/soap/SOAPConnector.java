package ru.strelchm.skb.api.soap;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import ru.strelchm.skb.api.soap.generated.GetUserRequest;
import ru.strelchm.skb.api.soap.generated.GetUserResponse;

public class SOAPConnector extends WebServiceGatewaySupport {

    public GetUserResponse callWebService(int id){
        GetUserRequest request = new GetUserRequest();
        request.setUserId(id);

        GetUserResponse response = (GetUserResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:9080/ws", request);
//                        new SoapActionCallback(
//                                "http://spring.io/guides/gs-producing-web-service/GetCountryRequest"));

        return response;
    }
}