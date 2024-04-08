package org.sample.neo4j.node;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
public class Year {

    @Id
    private String targetId;

    private String year;

    @Relationship(type = "DATE")
    private Date date;

    public Year(String targetId, String year, Date date) {
        this.targetId = targetId;
        this.year = year;
        this.date = date;
    }
}
