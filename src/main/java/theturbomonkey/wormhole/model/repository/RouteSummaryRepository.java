package theturbomonkey.wormhole.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import theturbomonkey.wormhole.model.entity.RouteSummary;

public interface RouteSummaryRepository extends JpaRepository<RouteSummary, Integer>
{

}
