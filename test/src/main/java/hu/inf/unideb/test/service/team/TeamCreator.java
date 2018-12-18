package hu.inf.unideb.test.service.team;

import hu.inf.unideb.test.service.player.PlayerService;
import hu.inf.unideb.test.service.user.UserService;
import static hu.inf.unideb.test.controller.PlayerController.alanyka;
import hu.inf.unideb.test.entity.EnemyTeam;
import hu.inf.unideb.test.entity.MyTeam;
import hu.inf.unideb.test.entity.User;
import hu.inf.unideb.test.service.match.ResultGenerator;
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

    public TeamCreator() {
    }
    final static Logger logger = LoggerFactory.getLogger(TeamCreator.class);

    @Autowired
    PlayerService playerService;

    @Autowired
    UserService userService;

    @Autowired
    EnemyTeamService enemyTeamService;

    @Autowired
    MyTeamService myTeamService;
    
    ResultGenerator resultGenerator;

    User jatekos = new User();
    public int team_osszertek=0;
    public int team2_osszertek=0;
    public int team3_osszertek=0;
    public int team_igazolasertek=0;
    public int team2_igazolasertek=0;
    public int team3_igazolasertek=0;
    public List<MyTeam> createMyTeam(int from, int to) {
        List<MyTeam> csapataim= new ArrayList<>();
        MyTeam csapat=new MyTeam();
        MyTeam csapat2=new MyTeam();
        MyTeam csapat3=new MyTeam();
        List<String> team = new ArrayList<>();
        List<String> team2 = new ArrayList<>();
        List<String> team3 = new ArrayList<>();
        logger.info("Kapus hozzaadva!");
        my_team_osszertek=0;
        my_team_igazolasertek = 0;
        team.addAll(playerService.getMyPlayers("kapus", 1, from, to));
        team.addAll(playerService.getMyPlayers("vedo", 4, from, to));
        team.addAll(playerService.getMyPlayers("kozeppalyas", 3, from, to));
        team.addAll(playerService.getMyPlayers("tamado", 3, from, to));
        team_osszertek=my_team_osszertek;
        System.out.println("Ertek1 "+ team_osszertek);
        team_igazolasertek=my_team_igazolasertek;
        my_team_osszertek=0;
        my_team_igazolasertek = 0;
        team2.addAll(playerService.getMyPlayers("kapus", 1, from, to));
        team2.addAll(playerService.getMyPlayers("vedo", 4, from, to));
        team2.addAll(playerService.getMyPlayers("kozeppalyas", 4, from, to));
        team2.addAll(playerService.getMyPlayers("tamado", 2, from, to));
        team2_osszertek=my_team_osszertek;
        System.out.println("Ertek2 "+ team2_osszertek);
        team2_igazolasertek=my_team_igazolasertek;
        my_team_osszertek=0;
        my_team_igazolasertek = 0;
        team3.addAll(playerService.getMyPlayers("kapus", 1, from, to));
        team3.addAll(playerService.getMyPlayers("vedo", 3, from, to));
        team3.addAll(playerService.getMyPlayers("kozeppalyas", 5, from, to));
        team3.addAll(playerService.getMyPlayers("tamado", 2, from, to));
        team3_osszertek=my_team_osszertek;
        System.out.println("Ertek3 "+ team3_osszertek);
        team3_igazolasertek=my_team_igazolasertek;
        logger.info("Csapat letrehozva");
        csapat.setId(alanyka.getId());
        csapat.setKapus(team.get(0));
        csapat.setVedoEgy(team.get(1));
        csapat.setVedoKetto(team.get(2));
        csapat.setVedoHarom(team.get(3));
        csapat.setVedoNegy(team.get(4));
        csapat.setKozepEgy(team.get(5));
        csapat.setKozepKetto(team.get(6));
        csapat.setKozepHarom(team.get(7));
        csapat.setKozepNegy(team.get(8));
        csapat.setTamadoEgy(team.get(9));
        csapat.setTamadoKetto(team.get(10));
        csapat2.setId(alanyka.getId());
        csapat2.setKapus(team2.get(0));
        csapat2.setVedoEgy(team2.get(1));
        csapat2.setVedoKetto(team2.get(2));
        csapat2.setVedoHarom(team2.get(3));
        csapat2.setVedoNegy(team2.get(4));
        csapat2.setKozepEgy(team2.get(5));
        csapat2.setKozepKetto(team2.get(6));
        csapat2.setKozepHarom(team2.get(7));
        csapat2.setKozepNegy(team2.get(8));
        csapat2.setTamadoEgy(team2.get(9));
        csapat2.setTamadoKetto(team2.get(10));
        csapat3.setId(alanyka.getId());
        csapat3.setKapus(team3.get(0));
        csapat3.setVedoEgy(team3.get(1));
        csapat3.setVedoKetto(team3.get(2));
        csapat3.setVedoHarom(team3.get(3));
        csapat3.setVedoNegy(team3.get(4));
        csapat3.setKozepEgy(team3.get(5));
        csapat3.setKozepKetto(team3.get(6));
        csapat3.setKozepHarom(team3.get(7));
        csapat3.setKozepNegy(team3.get(8));
        csapat3.setTamadoEgy(team3.get(9));
        csapat3.setTamadoKetto(team3.get(10));
        logger.info("Jatekosok lekerdezve!");        
        csapataim.add(csapat);
        csapataim.add(csapat2);
        csapataim.add(csapat3);
        return csapataim;
    }

    public void setTeam_osszertek(int team_osszertek) {
        this.team_osszertek = team_osszertek;
    }

    public void setTeam2_osszertek(int team2_osszertek) {
        this.team2_osszertek = team2_osszertek;
    }

    public void setTeam3_osszertek(int team3_osszertek) {
        this.team3_osszertek = team3_osszertek;
    }

    public void setTeam_igazolasertek(int team_igazolasertek) {
        this.team_igazolasertek = team_igazolasertek;
    }

    public void setTeam2_igazolasertek(int team2_igazolasertek) {
        this.team2_igazolasertek = team2_igazolasertek;
    }

    public void setTeam3_igazolasertek(int team3_igazolasertek) {
        this.team3_igazolasertek = team3_igazolasertek;
    }

    public int getTeam_osszertek() {
        return team_osszertek;
    }

    public int getTeam2_osszertek() {
        return team2_osszertek;
    }

    public int getTeam3_osszertek() {
        return team3_osszertek;
    }

    public int getTeam_igazolasertek() {
        return team_igazolasertek;
    }

    public int getTeam2_igazolasertek() {
        return team2_igazolasertek;
    }

    public int getTeam3_igazolasertek() {
        return team3_igazolasertek;
    }

    public EnemyTeam createEnemyTeam(EnemyTeam enemyTeam, int from, int to) {
        enemy_team_osszertek = 0;
        enemy_team_igazolasertek = 0;
        List<String> team = new ArrayList<String>();
        List<String> team2 = new ArrayList<String>();
        team2 = (playerService.getEnemyPlayers("kapus", 1, from, to));
        logger.info("Ellenfél kapus létrehozva!");
        team.addAll(team2);
        team.addAll(playerService.getEnemyPlayers("vedo", 4, from, to));
        team.addAll(playerService.getEnemyPlayers("kozeppalyas", 4, from, to));
        team.addAll(playerService.getEnemyPlayers("tamado", 2, from, to));
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
