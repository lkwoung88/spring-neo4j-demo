package org.sample.neo4j.repository;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.sample.neo4j.node.Signal;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SignalRepository extends Neo4jRepository<Signal, Long> {

//    @Query("")
//    List<Signal> getAllSignalByTargetIdAndMessageTime(@Param("targetId") String targetId,
//                                                      @Param("startDate") String startDate,
//                                                      @Param("endDate") String endDate);

    @Query("MATCH (ship:Ship {targetId: $targetId})-[:YEAR]-(year:Year)-[:DATE]-(date:Date)-[:SIGNAL]-(signal:Signal) " +
            "WHERE NOT EXISTS ((signal)-[:NEXT]->()) RETURN signal LIMIT 1")
    Signal getLatestSignal(@Param("targetId") String targetId);
}
