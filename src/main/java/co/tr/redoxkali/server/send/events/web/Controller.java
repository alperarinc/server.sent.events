package co.tr.redoxkali.server.send.events.web;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.events.CollectionEndEvent;
import reactor.core.publisher.Flux;

import java.awt.*;
import java.security.PublicKey;
import java.time.Duration;
import java.util.Collections;

@RestController
public class Controller {

    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Point> stream(){
        return Flux.interval(Duration.ofMillis(500))
                .map(interval -> Collections.singletonList(new Point()))
                .flatMapIterable(points -> points);
    }
}
