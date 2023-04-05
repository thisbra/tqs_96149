package ua.tqs.airQuality.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.tqs.airQuality.model.Weather;
import ua.tqs.airQuality.service.WeatherService;

@RestController
public class WeatherController {
    String baseUrl = "http://api.weatherbit.io/v2.0/current/airquality";

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather")
    public ResponseEntity<Weather> getWeather(@RequestParam("cityName") String cityName) {
        Weather weather = weatherService.getWeather(cityName);
        if (weather.getAqi() == null){
            return new ResponseEntity<Weather>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Weather>(weather, HttpStatus.OK);
    }
}
