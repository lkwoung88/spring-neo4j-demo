package org.sample.neo4j.service;

import org.sample.neo4j.data.SampleSignalGenerator;
import org.sample.neo4j.data.SampleSignalGenerator.SampleSignal;
import org.sample.neo4j.node.Date;
import org.sample.neo4j.node.Ship;
import org.sample.neo4j.node.Signal;
import org.sample.neo4j.node.Year;
import org.sample.neo4j.repository.ShipRepository;
import org.sample.neo4j.repository.SignalRepository;
import org.sample.neo4j.response.Response;
import org.sample.neo4j.response.ShipHistoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipTrackService {

    private SignalRepository signalRepository;
    private ShipRepository shipRepository;

    @Autowired
    public ShipTrackService(SignalRepository signalRepository, ShipRepository shipRepository) {
        this.signalRepository = signalRepository;
        this.shipRepository = shipRepository;
    }

    public ShipHistoryResponse getShipHistory(String targetId, String startDate, String endDate) {
//        signalRepository.
        return null;
    }

    public Response makeShipHistory() throws Exception{
        SampleSignalGenerator generator = new SampleSignalGenerator();
        List<SampleSignal> sampleSignals = generator.getSampleData(100);

        for (SampleSignal sampleSignal : sampleSignals) {

            Signal latestSignal = signalRepository.getLatestSignal(sampleSignal.getTargetId());

            Signal signal = new Signal(sampleSignal.getMessageTime());

            String messageTime = sampleSignal.getMessageTime();
            String targetId = sampleSignal.getTargetId();
            Date date = new Date(targetId, messageTime.substring(5, 10), signal);
            Year year = new Year(targetId, messageTime.substring(0, 4), date);
            Ship ship = new Ship(targetId, year);

            shipRepository.save(ship);

            if (latestSignal != null) {
                latestSignal.setSignal(signal);
                signalRepository.save(latestSignal);
            }
        }
        return new Response("SUCCESS");
    }
}
