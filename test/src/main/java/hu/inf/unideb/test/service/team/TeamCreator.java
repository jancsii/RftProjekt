package hu.inf.unideb.test.service.team;

import hu.inf.unideb.test.service.player.PlayerService;
import hu.inf.unideb.test.service.team.EnemyTeamService;
import hu.inf.unideb.test.service.user.UserService;
import hu.inf.unideb.test.service.team.MyTeamService;
import static hu.inf.unideb.test.controller.PlayerController.alanyka;
import hu.inf.unideb.test.entity.EnemyTeam;
import hu.inf.unideb.test.entity.MyTeam;
import hu.inf.unideb.test.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static hu.inf.unideb.test.service.player.PlayerServiceImpl.my_team_osszertek;
import static hu.inf.unideb.test.service.player.PlayerServiceImpl.enemy_team_osszertek;
import static hu.inf.unideb.test.service.player.PlayerServiceImpl.my_team_igazolasertek;
import static hu.inf.unideb.test.service.player.PlayerServiceImpl.enemy_team_igazolasertek;
import static hu.inf.unideb.test.service.match.ResultGenerator.probalkozas;
import static hu.inf.unideb.test.service.match.ResultGenerator.szint;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeamCreator {
    public  TeamCreator(){}
    final static Logger logger = LoggerFactory.getLogger(TeamCreator.class);

    @Autowired
    PlayerService playerService;
    
    @Autowired
    UserService userService;

    @Autowired
    EnemyTeamService enemyTeamService;
    
    @Autowired
    MyTeamService myTeamService;
    
    User jatekos = new User();
    public MyTeam createMyTeam(MyTeam myTeam, int from, int to)
    {
         my_team_osszertek=0;
        my_team_igazolasertek=0;
        List<String> team = new ArrayList<String>();
        List<String> team2 = new ArrayList<String>();
        team2=(playerService.getMyPlayers("kapus", 1,from,to));
        logger.info("Kapus hozzaadva!");
        team.addAll(team2);
        team.addAll(playerService.getMyPlayers("vedo", 4,from,to));
        team.addAll(playerService.getMyPlayers("kozeppalyas", 4,from,to));
        team.addAll(playerService.getMyPlayers("tamado", 2,from,to));
        logger.info("Csapat letrehozva");
        myTeam.setId(alanyka.getId());
        myTeam.setKapus(team.get(0));
        myTeam.setVedoEgy(team.get(1));
        myTeam.setVedoKetto(team.get(2));
        myTeam.setVedoHarom(team.get(3));
        myTeam.setVedoNegy(team.get(4));
        myTeam.setKozepEgy(team.get(5));
        myTeam.setKozepKetto(team.get(6));
        myTeam.setKozepHarom(team.get(7));
        myTeam.setKozepNegy(team.get(8));
        myTeam.setTamadoEgy(team.get(9));
        myTeam.setTamadoKetto(team.get(10));
        logger.info("Jatekosok lekerdezve!");
        return myTeam;
    }

    public EnemyTeam createEnemyTeam(EnemyTeam enemyTeam, int from, int to)
    {
        enemy_team_osszertek=0;
        enemy_team_igazolasertek=0;
        List<String> team = new ArrayList<String>();
        List<String> team2 = new ArrayList<String>();
        team2=(playerService.getEnemyPlayers("kapus", 1,from,to));
        logger.info("Ellenfél kapus létrehozva!");
        team.addAll(team2);
        team.addAll(playerService.getEnemyPlayers("vedo", 4,from,to));
        team.addAll(playerService.getEnemyPlayers("kozeppalyas", 4,from,to));
        team.addAll(playerService.getEnemyPlayers("tamado", 2,from,to));
        logger.info("Enemy csapat kész!");

        enemyTeam.setId(alanyka.getId());
        enemyTeam.setProbalkozas(probalkozas);
        enemyTeam.setSzint(szint);
        enemyTeam.setKapus(team.get(0));
        enemyTeam.setVedoEgy(team.get(1));
        enemyTeam.setVedoKetto(team.get(2));
        enemyTeam.setVedoHarom(team.get(3));
        enemyTeam.setVedoNegy(team.get(4));
        enemyTeam.setKozepEgy(team.get(5));
        enemyTeam.setKozepKetto(team.get(6));
        enemyTeam.setKozepHarom(team.get(7));
        enemyTeam.setKozepNegy(team.get(8));
        enemyTeam.setTamadoEgy(team.get(9));
        enemyTeam.setTamadoKetto(team.get(10));
        logger.info("Lekérdezés sikeres!");
        return enemyTeam;
    }

}
