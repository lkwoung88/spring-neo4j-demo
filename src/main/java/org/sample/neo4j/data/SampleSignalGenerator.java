package org.sample.neo4j.data;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class SampleSignalGenerator {

    private static final String[] TARGET_IDS = {"ID001", "ID002", "ID003", "ID004", "ID005", "ID006"};

    private List<SampleSignal> sampleSignals = new ArrayList<>();

    public List<SampleSignal> getSampleData(int numSignals) {

        Random random = new Random();

        for (int i = 0; i < numSignals; i++) {
            String targetId = TARGET_IDS[random.nextInt(TARGET_IDS.length)];

            LocalDateTime currentTime = LocalDateTime.now().plusSeconds(30 + random.nextInt(5 * 60 - 30));
            String messageTime = currentTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);

            this.sampleSignals.add(new SampleSignal(targetId, messageTime));
        }

        this.sampleSignals.sort(Comparator.comparing(s -> LocalDateTime.parse(s.getMessageTime())));

        return this.sampleSignals;
    }

    @Getter
    public class SampleSignal {
        private String targetId;
        private String messageTime;

        public SampleSignal(String targetId, String messageTime) {
            this.targetId = targetId;
            this.messageTime = messageTime;
        }
    }

}
