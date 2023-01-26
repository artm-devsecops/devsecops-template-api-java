package devsecops.template.api.java.services;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import devsecops.template.api.java.models.JwtResponse;
import devsecops.template.api.java.options.AzureADRegistrationOptions;

@Service
public class AzureADAuthorizationService implements IAuthorizationService {

    private final Logger logger = LoggerFactory.getLogger(AzureADAuthorizationService.class);

    private final URI baseAddress = URI.create("https://login.microsoftonline.com/");
    private final AzureADRegistrationOptions options;
    private final HttpHeaders headers;
    private final RestTemplate restTemplate;
    private final String tenantId;

    @Autowired
    public AzureADAuthorizationService(AzureADRegistrationOptions options, RestTemplate restTemplate,
            HttpHeaders headers) {
        this.options = options;
        this.headers = headers;
        this.restTemplate = restTemplate;
        this.tenantId = options.getTenantId();
    }

    @Override
    public JwtResponse getOnBehalfOfJwt(String scope) {
        logger.info("getOnBehalfOfJwt");

        headers.setBearerAuth(headers.getFirst("AccessToken"));

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "urn:ietf:params:oauth:grant-type:jwt-bearer");
        body.add("client_id", options.getClientId());
        body.add("client_secret", options.getClientSecret());
        body.add("assertion", headers.getFirst("AccessToken"));
        body.add("scope", scope);
        body.add("requested_token_use", "on_behalf_of");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, headers);
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("tenantId", tenantId);

        return restTemplate.postForObject(baseAddress + "/{tenantId}/oauth2/v2.0/token", request,
                JwtResponse.class, uriVariables);
    }
}
