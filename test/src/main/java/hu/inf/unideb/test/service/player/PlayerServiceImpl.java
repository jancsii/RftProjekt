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
    public List<Player> nemhasznalt = new ArrayList<>();
    private int temp = 0;
    public static List<String> kapus = new ArrayList<>();
    public static List<String> vedo = new ArrayList<>();
    public static List<String> kozep = new ArrayList<>();
    public static List<String> tamado = new ArrayList<>();
    
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
    public  List<String> kapusok(List<Player> nemhasznalt){
                kapus=nemhasznalt.stream().filter(e->e.getPoszt().equals("kapus"))
                        .map(e->e.getNev())
                .collect(Collectors.toList());
        return kapus;
    }

    @Override
    public List<Integer> getKapus_ertek() {
        return kapus_ertek;
    }

    @Override
    public void setKapus_ertek(List<Integer> kapus_ertek) {
        this.kapus_ertek = kapus_ertek;
    }

    @Override
    public List<Integer> getVedo_ertek() {
        return vedo_ertek;
    }

    @Override
    public void setVedo_ertek(List<Integer> vedo_ertek) {
        this.vedo_ertek = vedo_ertek;
    }

    @Override
    public List<Integer> getKozep_ertek() {
        return kozep_ertek;
    }

    @Override
    public void setKozep_ertek(List<Integer> kozep_ertek) {
        this.kozep_ertek = kozep_ertek;
    }

    @Override
    public List<Integer> getTamado_ertek() {
        return tamado_ertek;
    }

    @Override
    public void setTamado_ertek(List<Integer> tamado_ertek) {
        this.tamado_ertek = tamado_ertek;
    }

    public List<Integer> getKapus_igazolas() {
        return kapus_igazolas;
    }

    public void setKapus_igazolas(List<Integer> kapus_igazolas) {
        this.kapus_igazolas = kapus_igazolas;
    }

    public List<Integer> getVedo_igazolas() {
        return vedo_igazolas;
    }

    public void setVedo_igazolas(List<Integer> vedo_igazolas) {
        this.vedo_igazolas = vedo_igazolas;
    }

    public List<Integer> getKozep_igazolas() {
        return kozep_igazolas;
    }

    public void setKozep_igazolas(List<Integer> kozep_igazolas) {
        this.kozep_igazolas = kozep_igazolas;
    }

    public List<Integer> getTamado_igazolas() {
        return tamado_igazolas;
    }

    public void setTamado_igazolas(List<Integer> tamado_igazolas) {
        this.tamado_igazolas = tamado_igazolas;
    }
    public List<Integer> kapus_ertek=new ArrayList();
    public List<Integer> vedo_ertek=new ArrayList();
    public List<Integer> kozep_ertek=new ArrayList();
    public List<Integer> tamado_ertek=new ArrayList();
    public List<Integer> kapus_igazolas=new ArrayList();
    public List<Integer> vedo_igazolas=new ArrayList();
    public List<Integer> kozep_igazolas=new ArrayList();
    public List<Integer> tamado_igazolas=new ArrayList();
    
    @Override
    public  List<Integer> kapusok_igazolas(List<Player> nemhasznalt){
                kapus_ertek=nemhasznalt.stream().filter(e->e.getPoszt().equals("kapus"))
                        .map(e->e.getErtek())
                .collect(Collectors.toList());
        return kapus_ertek;
    }
    @Override
    public  List<Integer> kapusok_ertek(List<Player> nemhasznalt){
                kapus_igazolas=nemhasznalt.stream().filter(e->e.getPoszt().equals("kapus"))
                        .map(e->e.getRang())
                .collect(Collectors.toList());
        return kapus_igazolas;
    }
    
    @Override
        public  List<Integer> vedo_igazolas(List<Player> nemhasznalt){
                vedo_ertek=nemhasznalt.stream().filter(e->e.getPoszt().equals("vedo"))
                        .map(e->e.getErtek())
                .collect(Collectors.toList());
        return vedo_ertek;
    }
    @Override
    public  List<Integer> vedo_ertek(List<Player> nemhasznalt){
                vedo_igazolas=nemhasznalt.stream().filter(e->e.getPoszt().equals("vedo"))
                        .map(e->e.getRang())
                .collect(Collectors.toList());
        return vedo_igazolas;
    }
    @Override
        public  List<Integer> kozep_igazolas(List<Player> nemhasznalt){
                kozep_ertek=nemhasznalt.stream().filter(e->e.getPoszt().equals("kozeppalyas"))
                        .map(e->e.getErtek())
                .collect(Collectors.toList());
        return kozep_ertek;
    }
    @Override
    public  List<Integer> kozep_ertek(List<Player> nemhasznalt){
                kozep_igazolas=nemhasznalt.stream().filter(e->e.getPoszt().equals("kozeppalyas"))
                        .map(e->e.getRang())
                .collect(Collectors.toList());
        return kozep_igazolas;
    }
    @Override
        public  List<Integer> tamado_igazolas(List<Player> nemhasznalt){
                tamado_ertek=nemhasznalt.stream().filter(e->e.getPoszt().equals("tamado"))
                        .map(e->e.getErtek())
                .collect(Collectors.toList());
        return tamado_ertek;
    }
    @Override
    public  List<Integer> tamado_ertek(List<Player> nemhasznalt){
                tamado_igazolas=nemhasznalt.stream().filter(e->e.getPoszt().equals("tamado"))
                        .map(e->e.getRang())
                .collect(Collectors.toList());
        return tamado_igazolas;
    }
    @Override
    public  List<String> vedok(List<Player> nemhasznalt){
                vedo=nemhasznalt.stream().filter(e->e.getPoszt().equals("vedo"))
                        .map(e->e.getNev())
                .collect(Collectors.toList());
        return vedo;
    }
    @Override
    public  List<String> kozepek(List<Player> nemhasznalt){
                kozep=nemhasznalt.stream().filter(e->e.getPoszt().equals("kozeppalyas"))
                        .map(e->e.getNev())
                .collect(Collectors.toList());
        return kozep;
    }
    @Override
    public List<String> tamadok(List<Player> nemhasznalt){
                tamado=nemhasznalt.stream().filter(e->e.getPoszt().equals("tamado"))
                        .map(e->e.getNev())
                .collect(Collectors.toList());
        return tamado;
    }
}
