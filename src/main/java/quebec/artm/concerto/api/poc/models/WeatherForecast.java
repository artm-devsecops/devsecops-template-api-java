package quebec.artm.concerto.api.poc.models;

import java.time.OffsetDateTime;

import org.springframework.lang.Nullable;

public class WeatherForecast {
    private OffsetDateTime date;

    public OffsetDateTime getDate() {
        return this.date;
    }

    public void setDate(OffsetDateTime date) {
        this.date = date;
    }

    private int temperatureC;

    public int getTemperatureC() {
        return this.temperatureC;
    }

    public void setTemperatureC(int temperatureC) {
        this.temperatureC = temperatureC;
    }

    public int getTemperatureF() {
        return 32 + (int) (this.temperatureC / 0.5556);
    }

    private String summary;

    @Nullable
    public String getSummary() {
        return this.summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
