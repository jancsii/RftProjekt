package hu.inf.unideb.test.service.player;

import hu.inf.unideb.test.entity.Player;
import hu.inf.unideb.test.repository.PlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService{

    final static Logger logger = LoggerFactory.getLogger(PlayerServiceImpl.class);

    @Autowired
    PlayerRepository playerRepository;

    public List<Player> enemyTeam = new ArrayList<>();
    public static int my_team_osszertek=0;
    public static int enemy_team_osszertek=0;
    public static int my_team_igazolasertek=0;
    public static int enemy_team_igazolasertek=0;
    public List<Player> allPlayers;
    public static List<Player> selectTeam = new ArrayList<>();
    public static List<Player> nemhasznalt = new ArrayList<>();
    private int temp = 0;
    
    @Override
    public Iterable<Player> getAllPlayers()
    {
        return playerRepository.findAll();
    }
   
    @Override
    public List<Player> getNemhasznalt() {
        return nemhasznalt;
    }

    @Override
    public void setNemhasznalt(List<Player> nemhasznalt) {
        this.nemhasznalt = nemhasznalt;
    }

    @Override
    public List<String> getMyPlayers(String position, int number, int from, int to) {
        if(temp%4==0){
            allPlayers = (List) playerRepository.findAll();
        }
        temp++;
        logger.info("Jatekosok posztonkenti szukitese!");
        List<String> players = allPlayers
                .stream().filter(e -> e.getRang() >= from && e.getRang() <= to && e.getPoszt().equals(position))
                .map(Player::getNev)
                .collect(Collectors.toList());
        logger.info("Megvannak {}" + players);
        List<Integer> players_ertek =allPlayers
                .stream().filter(e -> e.getRang() >= from && e.getRang() <= to && e.getPoszt().equals(position))
                .map((player) -> player.getRang())
                .collect(Collectors.toList());
        List<Integer> players_igazolas =allPlayers
                .stream().filter(e -> e.getRang() >= from && e.getRang() <= to && e.getPoszt().equals(position))
                .map((player) -> player.getErtek())
                .collect(Collectors.toList());
        return rand(players,number,players_ertek,players_igazolas);
    }
    
    @Override
    public List<String> getEnemyPlayers(String position, int number, int from, int to) {
        List<String> players = selectTeam
                .stream().filter(e -> e.getRang() >= from && e.getRang() <= to && e.getPoszt().equals(position))
                .map(Player::getNev)
                .collect(Collectors.toList());
        List<Integer> players_ertek =selectTeam
                .stream().filter(e -> e.getRang() >= from && e.getRang() <= to && e.getPoszt().equals(position))
                .map((player) -> player.getRang())
                .collect(Collectors.toList());
        List<Integer> players_igazolas =selectTeam
                .stream().filter(e -> e.getRang() >= from && e.getRang() <= to && e.getPoszt().equals(position))
                .map((player) -> player.getErtek())
                .collect(Collectors.toList());
        return randomEnemy(players,number,players_ertek,players_igazolas);
    }
    
    
    public List<String> rand(List<String> li, int number,List<Integer> lista,List<Integer>igazolas){
        Random r = new Random();
        List<String> temp_list = new ArrayList<>();
        List<Integer> temp_lista= new ArrayList<>();
        List<Integer> temp_igazolas=new ArrayList<>();
        for(int i=0; i<number; i++)
        {
            logger.info("random {} {} ", temp_list,li);
            int randnum = r.nextInt(li.size());
            temp_list.add(li.get(randnum));
            temp_lista.add(lista.get(randnum));
            temp_igazolas.add(igazolas.get(randnum));
            allPlayers.removeIf(e -> e.getNev().equals(li.get(randnum)));
            li.remove(randnum);
            lista.remove(randnum);
            igazolas.remove(randnum);
        }
        int my_team_reszertek=temp_lista.stream().mapToInt(e->e).sum();
        my_team_osszertek+=my_team_reszertek;
        int my_team_reszigazolas=temp_igazolas.stream().mapToInt(e->e).sum();
        my_team_igazolasertek+=my_team_reszigazolas;
        selectTeam = new ArrayList<>(allPlayers);
        return temp_list;
    }

    private List<String> randomEnemy(List<String> li, int number,List<Integer> lista,List<Integer> igazolas){
        Random r = new Random();
        List<String> temp_enemy_list = new ArrayList<>();
        List<Integer> temp_enemy_lista= new ArrayList<>();
        List<Integer> temp_enemy_igazolas=new ArrayList<>();
        for(int i=0; i<number; i++)
        {
            logger.info("random {} {} ", temp_enemy_list,li);
            int randnum = r.nextInt(li.size());
            temp_enemy_list.add(li.get(randnum));
            temp_enemy_lista.add(lista.get(randnum));
            temp_enemy_igazolas.add(igazolas.get(randnum));
            selectTeam.removeIf(e -> e.getNev().equals(li.get(randnum)));
            li.remove(randnum);
            lista.remove(randnum);
            igazolas.remove(randnum);
        }
        int enemy_team_reszertek=temp_enemy_lista.stream().mapToInt(e->e).sum();
        enemy_team_osszertek+=enemy_team_reszertek;
        int enemy_team_reszigazolas=temp_enemy_igazolas.stream().mapToInt(e->e).sum();
        enemy_team_igazolasertek+=enemy_team_reszigazolas;
        nemhasznalt = new ArrayList<>(selectTeam);
        return temp_enemy_list;
    }
    @Override
    public  List<Player> kapusok(List<Player> nemhasznalt){
                List<Player> kapus=nemhasznalt.stream().filter(e->e.getPoszt().equals("kapus"))
                .collect(Collectors.toList());
        return kapus;
    }


    @Override
    public  List<Player> vedok(List<Player> nemhasznalt){
               List<Player> vedo=nemhasznalt.stream().filter(e->e.getPoszt().equals("vedo"))
                .collect(Collectors.toList());
        return vedo;
    }
    @Override
    public  List<Player> kozepek(List<Player> nemhasznalt){
               List<Player> kozep=nemhasznalt.stream().filter(e->e.getPoszt().equals("kozeppalyas"))
                .collect(Collectors.toList());
        return kozep;
    }
    @Override
    public List<Player> tamadok(List<Player> nemhasznalt){
               List<Player> tamado=nemhasznalt.stream().filter(e->e.getPoszt().equals("tamado"))
                .collect(Collectors.toList());
        return tamado;
    }
}
