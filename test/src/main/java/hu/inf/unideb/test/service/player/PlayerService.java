package hu.inf.unideb.test.service.player;

import hu.inf.unideb.test.entity.Player;

import java.util.List;


public interface PlayerService {

    public Iterable<Player> getAllPlayers();

    public List<String> getMyPlayers(String position, int number, int from, int to);
    
    public List<String> getEnemyPlayers(String position, int number, int from, int to);
    public List<Player> getNemhasznalt();
    public void setNemhasznalt(List<Player> nemhasznalt);
    public List<String> kapusok(List<Player> kapus);
    public List<String> kozepek(List<Player> kozep);
    public List<String> vedok(List<Player> vedo);
    public List<String> tamadok(List<Player> tamado);
}
