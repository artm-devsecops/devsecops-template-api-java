package quebec.artm.concerto.api.poc.services;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class MicrosoftGraphService implements IIAMService {

    private final Logger logger = LoggerFactory.getLogger(AzureADAuthorizationService.class);

    private final URI baseAddress = URI.create("https://graph.microsoft.com/");
    private final IAuthorizationService authorizationService;
    private final RestTemplate httpClient;

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
