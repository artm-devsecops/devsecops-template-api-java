package quebec.artm.concerto.api.poc.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/health")
@PreAuthorize("hasRole('ROLE_USER')")
public class HealthController {
    private final Logger logger = LoggerFactory.getLogger(HealthController.class);

    @GetMapping("/startup")
    public void GetStartup() {
        logger.info("startup");
    }

    @GetMapping("/readiness")
    public void GetReadiness() {
        logger.info("readiness");
    }

    @GetMapping("/liveness")
    public void GetLiveness() {
        logger.info("liveness");
    }
}
