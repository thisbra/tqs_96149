package ua.tqs.airQuality.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.tqs.airQuality.model.Weather;
import ua.tqs.airQuality.service.CacheService;

@RestController
public class CacheStatisticController {

    @Autowired
    private CacheService cacheService;

    @GetMapping("/cache")
    public ResponseEntity<String> getCacheStatistics() {
        JSONObject responseBody = cacheService.getStatistics();
        return new ResponseEntity<String>(responseBody.toString(), HttpStatus.OK);
    }
}