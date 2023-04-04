package ua.tqs.airQuality.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.tqs.airQuality.model.Weather;
import ua.tqs.airQuality.service.WeatherService;

@Controller
public class WebIndexController {
    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }
}
