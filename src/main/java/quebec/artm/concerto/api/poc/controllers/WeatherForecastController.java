package quebec.artm.concerto.api.poc.controllers;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import quebec.artm.concerto.api.poc.models.WeatherForecast;

@RestController
public class WeatherForecastController {

    private static final String[] Summaries = new String[] {
            "Freezing", "Bracing", "Chilly", "Cool", "Mild", "Warm", "Balmy", "Hot", "Sweltering", "Scorching"
    };

    @GetMapping("/weatherforecast")
    public WeatherForecast[] index() {
        Random rand = new Random();
        ArrayList<WeatherForecast> w = new ArrayList<WeatherForecast>();
        for (int i = 1; i <= 5; i++) {
            var w1 = new WeatherForecast();
            w1.setDate(OffsetDateTime.now());
            int randomNum = -20 + rand.nextInt((55 - -20) + 1);
            w1.setTemperatureC(randomNum);
            w1.setSummary(Summaries[rand.nextInt(Summaries.length)]);
            w.add(w1);
        }

        WeatherForecast[] payload = new WeatherForecast[w.size()];
        return w.toArray(payload);
    }
}
