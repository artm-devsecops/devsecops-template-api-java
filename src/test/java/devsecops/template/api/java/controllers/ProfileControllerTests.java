package devsecops.template.api.java.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import devsecops.template.api.java.services.MicrosoftGraphService;

public class ProfileControllerTests {

    @Test
    public void getBasicProfileReturnsPayload() {
        // arrange
        MicrosoftGraphService iamService = Mockito.mock(MicrosoftGraphService.class);
        ProfileController sut = new ProfileController(iamService);
        String json = "{ \"givenName\": \"Bob\" }";

        Mockito.when(iamService.getBasicProfile()).thenReturn(json);

        // act
        ResponseEntity<String> result = sut.me();

        // assert
        assertEquals(json, result.getBody());
        Mockito.verify(iamService, Mockito.times(1)).getBasicProfile();
    }

}