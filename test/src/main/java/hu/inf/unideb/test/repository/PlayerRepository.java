package hu.inf.unideb.test.repository;

import hu.inf.unideb.test.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    @Query("SELECT t FROM Player t where t.nev = :nev AND t.poszt= :poszt")
    public Player findByName(@Param("nev") String nev, @Param("poszt") String poszt);
}
