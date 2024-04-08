package org.sample.neo4j.node;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
public class Date {

    @Id
    private String targetId;

    private String date;

    @Relationship(type = "SIGNAL")
    private Signal signal;

    public Date(String targetId, String date, Signal signal) {
        this.targetId = targetId;
        this.date = date;
        this.signal = signal;
    }
}
