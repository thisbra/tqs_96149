package ua.tqs.airQuality.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebIndexController {
    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Hello World";
    }
//    public String index() {
//        return "index";
//    }
}
