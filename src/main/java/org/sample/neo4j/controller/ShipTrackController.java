package org.sample.neo4j.controller;

import lombok.extern.slf4j.Slf4j;
import org.sample.neo4j.node.Ship;
import org.sample.neo4j.node.Signal;
import org.sample.neo4j.response.Response;
import org.sample.neo4j.response.ShipHistoryResponse;
import org.sample.neo4j.service.ShipTrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin("*")
public class ShipTrackController {

    private ShipTrackService shipTrackService;

    @Autowired
    public ShipTrackController(ShipTrackService shipTrackService) {
        this.shipTrackService = shipTrackService;
    }

    @ExceptionHandler(Exception.class)
    public Response exceptionCatcher(Exception exception) {
        Response response = new Response("Exception!!");
        log.info("exception = ", exception);

        return response;
    }

    @PostMapping("/get/signal")
    public ShipHistoryResponse getSignal(@RequestParam("targetId") String targetId,
                                         @RequestParam("startDate") String startDate,
                                         @RequestParam("endDate") String endDate) {
        return shipTrackService.getShipHistory(targetId, startDate, endDate);
    }

    @GetMapping("/make/signal")
    public Response makeResponse() throws Exception {
        return shipTrackService.makeShipHistory();
    }
}
