package devsecops.template.api.java.controllers;

import org.junit.jupiter.api.Test;

public class HealthControllerTests {
    @Test
    public void getStartupReturnsOk() {
        // arrange
        HealthController healthController = new HealthController();

        // act
        healthController.GetStartup();
    }

    @Test
    public void getReadinessReturnsOk() {
        // arrange
        HealthController healthController = new HealthController();

        // act
        healthController.GetReadiness();
    }

    @Test
    public void getLivenessReturnsOk() {
        // arrange
        HealthController healthController = new HealthController();

        // act
        healthController.GetLiveness();
    }
}
