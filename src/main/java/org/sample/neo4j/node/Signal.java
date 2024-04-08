package org.sample.neo4j.node;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
public class Signal {

    @Id
    @GeneratedValue
    private Long sequence;

    private String messageTime;

    @Relationship(type = "NEXT", direction = Relationship.Direction.OUTGOING)
    private Signal signal;

    public Signal(String messageTime) {
        this.messageTime = messageTime;
    }

    public void setSignal(Signal signal) {
        this.signal = signal;
    }
}
