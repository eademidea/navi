package br.com.navi.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
//@Slf4j
public class LiturgyServiceImpl {


    private RestTemplate restTemplate;

    public LiturgyServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getLiturgy() {
        var response = restTemplate.exchange("https://liturgia.up.railway.app/"
                , HttpMethod.GET
                , getRequestEntity()
                , String.class);
        if (!(response.hasBody() && response.getStatusCode().is2xxSuccessful())) {
            throw new RuntimeException("Erro na chamada da api liturgia.up.railway.app");
            //TODO: Lançar exceção realizar tratativa
        }

        return response.getBody();
    }

    private static HttpEntity<Object> getRequestEntity() {
        return new HttpEntity<>(null, new HttpHeaders());
    }


}
