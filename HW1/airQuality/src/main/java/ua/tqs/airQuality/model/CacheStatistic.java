package ua.tqs.airQuality.model;

import lombok.Getter;

@Getter
public class CacheStatistic {

    private Integer requests;
    private Integer founds;
    private Integer notFounds;

    public CacheStatistic() {
        requests = 0;
        founds = 0;
        notFounds = 0;
    }

    private void addRequest() {
        requests++;
    }

    public void addFounds() {
        founds++;
        addRequest();
    }

    public void addNotFounds() {
        notFounds++;
        addRequest();
    }

}
