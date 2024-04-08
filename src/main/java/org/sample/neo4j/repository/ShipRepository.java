package org.sample.neo4j.repository;

import org.sample.neo4j.node.Ship;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipRepository extends Neo4jRepository<Ship, String> {
}
