package hu.inf.unideb.test.service.team;

import hu.inf.unideb.test.entity.EnemyTeam;
import hu.inf.unideb.test.repository.EnemyTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnemyTeamServiceImpl implements EnemyTeamService {

    @Autowired
    EnemyTeamRepository enemyTeamRepository;

    @Override
    public EnemyTeam create(EnemyTeam enemyTeam) {
        return enemyTeamRepository.save(enemyTeam);
    }
}
