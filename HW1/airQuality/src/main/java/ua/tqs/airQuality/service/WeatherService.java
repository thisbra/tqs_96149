package ua.tqs.airQuality.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ua.tqs.airQuality.model.Weather;


@Service
public class WeatherService {
    private String token = "a6b32597710ca2dd49f707eccdce1a7297c65509";

    UriComponentsBuilder uriBuilder;

    @Autowired
    private CacheService cache;

    public WeatherService() {
        uriBuilder = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("api.waqi.info")
                .path("feed");
//                .queryParam("token", key);

    }
    public Weather getWeather(String cityName) {
        Weather inCacheWeather = cache.get(cityName);
        if (inCacheWeather != null) {
            return inCacheWeather;
        }

        UriComponentsBuilder newUrl = (UriComponentsBuilder) UriComponentsBuilder.fromUri(uriBuilder.build().toUri()).clone();
        String url = newUrl
                .pathSegment(cityName)
                .queryParam("token", token)
                .build()
                .toString();

        RestTemplate restTemplate = new RestTemplate();
        System.out.println(url);
        ResponseEntity<String> responseData = restTemplate.getForEntity(url, String.class);

        if (responseData.getStatusCode().value() != 200) {
            return new Weather();
        }

        Weather weather = new Weather();

        try {
            JSONObject jsonResponse = new JSONObject(responseData.getBody());
            System.out.println(jsonResponse);
            JSONObject data = jsonResponse.getJSONObject("data");

            weather.setAqi(data.getBigDecimal("aqi"));

            // extract 'iaqi' object
            JSONObject iaqi = data.getJSONObject("iaqi");
            System.out.println(iaqi.toString());

            // extract values
            weather.setSo2(iaqi.getJSONObject("so2").getBigDecimal("v"));
            weather.setNo2(iaqi.getJSONObject("no2").getBigDecimal("v"));
            weather.setO3(iaqi.getJSONObject("o3").getBigDecimal("v"));
            weather.setPm25(iaqi.getJSONObject("pm25").getBigDecimal("v"));
            weather.setPm10(iaqi.getJSONObject("pm10").getBigDecimal("v"));
            weather.setH(iaqi.getJSONObject("h").getBigDecimal("v"));
            weather.setP(iaqi.getJSONObject("p").getBigDecimal("v"));
            weather.setT(iaqi.getJSONObject("t").getBigDecimal("v"));
            weather.setWg(iaqi.getJSONObject("wg").getBigDecimal("v"));
            weather.setW(iaqi.getJSONObject("w").getBigDecimal("v"));


            weather.setCityName(cityName);


        } catch (JSONException exception) {
            String error = exception.getMessage();
        }

        cache.store(cityName, weather);

        return weather;
        }

}
