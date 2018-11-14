package hu.inf.unideb.test.service.player;

import hu.inf.unideb.test.entity.Player;

import java.util.List;


public interface PlayerService {

    public Iterable<Player> getAllPlayers();

    public List<String> getMyPlayers(String position, int number, int from, int to);
    public List<String> getEnemyPlayers(String position, int number, int from, int to);
    public List<Player> getNemhasznalt();
    public void setNemhasznalt(List<Player> nemhasznalt);
    public List<Player> kapusok(List<Player> kapus);
    public List<Player> kozepek(List<Player> kozep);
    public List<Player> vedok(List<Player> vedo);
    public List<Player> tamadok(List<Player> tamado);
    Player getPlayerByName(String name,String poszt);
    Player getLowBack(String name1, String name2, String name3,String name4,String poszt);
    Player getStriker(String name1, String name2,String poszt);

}
