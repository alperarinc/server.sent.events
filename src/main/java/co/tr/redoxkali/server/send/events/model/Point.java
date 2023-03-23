package co.tr.redoxkali.server.send.events.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.concurrent.ThreadLocalRandom;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Point {

    private static final Double MIN_LAT = 36.000;
    private static final Double MAX_LAT = 42.00;
    private static final Double MIN_LONG =26.00 ;
    private static final Double MAX_LONG = 45.00;

    private final Double latitude;
    private final Double longitude;

    public Point(){
        this.latitude = ThreadLocalRandom.current().nextDouble(MIN_LAT, MAX_LAT);
        this.longitude = ThreadLocalRandom.current().nextDouble(MIN_LONG, MAX_LONG);

    }
}
