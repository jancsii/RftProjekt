package hu.inf.unideb.test.service.team;

import hu.inf.unideb.test.service.team.MyTeamService;
import hu.inf.unideb.test.entity.MyTeam;
import hu.inf.unideb.test.repository.MyTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyTeamServiceImpl implements MyTeamService{

    @Autowired
    MyTeamRepository myTeamRepository;

    @Override
    public MyTeam create(MyTeam myTeam) {

        return myTeamRepository.save(myTeam);
    }
}
