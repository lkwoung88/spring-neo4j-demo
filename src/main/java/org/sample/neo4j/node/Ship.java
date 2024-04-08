package org.sample.neo4j.node;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
public class Ship {

    @Id
    private String targetId;

    @Relationship(type = "YEAR")
    private Year year;

    public Ship(String targetId, Year year) {
        this.targetId = targetId;
        this.year = year;
    }
}
