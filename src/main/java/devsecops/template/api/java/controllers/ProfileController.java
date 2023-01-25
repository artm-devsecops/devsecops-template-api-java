package devsecops.template.api.java.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import devsecops.template.api.java.services.IIAMService;

@RestController
@RequestMapping("/profile")
@PreAuthorize("hasRole('ROLE_USER')")
public class ProfileController {

    private final Logger logger = LoggerFactory.getLogger(HealthController.class);

    private final IIAMService iamService;

    public ProfileController(IIAMService iamService) {
        this.iamService = iamService;
    }

    @PreAuthorize("hasAuthority('User.Read')")
    @GetMapping("/me")
    public ResponseEntity<String> me() {
        logger.info("me");

        String json = iamService.getBasicProfile();
        return new ResponseEntity<>(json, HttpStatus.OK);
    }
}
