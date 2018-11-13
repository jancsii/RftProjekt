package hu.inf.unideb.test.repository;

import hu.inf.unideb.test.entity.EnemyTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnemyTeamRepository extends JpaRepository<EnemyTeam, Integer>{
}
