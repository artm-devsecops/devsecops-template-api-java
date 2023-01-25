package devsecops.template.api.java.services;

import devsecops.template.api.java.models.JwtResponse;

public interface IAuthorizationService {
    public JwtResponse getOnBehalfOfJwt(String scope);
}
