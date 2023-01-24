package quebec.artm.concerto.api.poc.services;

import quebec.artm.concerto.api.poc.models.JwtResponse;

public interface IAuthorizationService {
    public JwtResponse getOnBehalfOfJwt(String scope);
}
