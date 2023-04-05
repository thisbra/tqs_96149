package ua.tqs.airQuality.controller;

import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.tqs.airQuality.model.Weather;
import ua.tqs.airQuality.service.WeatherService;

@Controller
public class WebWeatherController {

    @Autowired
    private WeatherService weatherService;

    @ApiOperation(value = "get specific city weather")
    @RequestMapping("/weatherFromCity")
    public ModelAndView webWeather(@RequestParam("cityName") String cityName) {
        Weather weather = weatherService.getWeather(cityName);
        ModelAndView mv;
        if (weather.getAqi() == null){
            mv = new ModelAndView("error");
            return mv;
        }
        mv = new ModelAndView("weather");

        mv.addObject("weather", weather);

        return mv;
    }

}