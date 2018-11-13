package hu.inf.unideb.test.repository;

import hu.inf.unideb.test.entity.MyTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyTeamRepository extends JpaRepository<MyTeam, Integer> {
}
