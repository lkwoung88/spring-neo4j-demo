package org.sample.neo4j.response;

import lombok.Getter;
import lombok.Setter;
import org.sample.neo4j.node.Signal;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ShipHistoryResponse extends Response {

    private List<Signal> signalList = new ArrayList<>();

    public ShipHistoryResponse(String message, List<Signal> signalList) {
        super(message);
        this.signalList = signalList;
    }
}
