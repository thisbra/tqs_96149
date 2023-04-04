package ua.tqs.airQuality.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Weather {
    private String cityName;
    private BigDecimal aqi;
    private BigDecimal h;
    private BigDecimal no2;
    private BigDecimal o3;
    private BigDecimal p;
    private BigDecimal pm10;
    private BigDecimal pm25;
    private BigDecimal so2;
    private BigDecimal t;
    private BigDecimal w;
    private BigDecimal wg;
}
