package devsecops.template.api.java.services;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MicrosoftGraphService implements IIAMService {

    private final Logger logger = LoggerFactory.getLogger(MicrosoftGraphService.class);

    private final URI baseAddress = URI.create("https://graph.microsoft.com/");
    private final IAuthorizationService authorizationService;
    private final RestTemplate httpClient;

    @Autowired
    public MicrosoftGraphService(IAuthorizationService authorizationService, RestTemplate httpClient) {
        this.authorizationService = authorizationService;
        this.httpClient = httpClient;
    }

    @Override
    public String getBasicProfile() {

        logger.info("getBasicProfile");

        var jwt = authorizationService.getOnBehalfOfJwt(baseAddress.resolve("user.read").toString());

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(jwt.getAccessToken());
        HttpEntity<String> request = new HttpEntity<>(headers);
        ResponseEntity<String> response = httpClient.exchange(baseAddress.resolve("v1.0/me").toString(),
                HttpMethod.GET, request, String.class);
        return response.getBody();
    }
}
