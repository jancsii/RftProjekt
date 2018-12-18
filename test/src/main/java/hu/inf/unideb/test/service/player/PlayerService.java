package hu.inf.unideb.test.service.player;

import hu.inf.unideb.test.entity.Player;

import java.util.List;


public interface PlayerService {

    Iterable<Player> getAllPlayers();

    List<String> getMyPlayers(String position, int number, int from, int to);
    List<String> getEnemyPlayers(String position, int number, int from, int to);
    List<Player> getNemhasznalt();
    void setNemhasznalt(List<Player> nemhasznalt);
    List<Player> kapusok(List<Player> kapus, int money);
    List<Player> kozepek(List<Player> kozep, int money);
    List<Player> vedok(List<Player> vedo, int money);
    List<Player> tamadok(List<Player> tamado, int money);
    Player getPlayerByName(String name,String poszt);
    Player getLowBack(String name1, String name2, String name3,String name4,String poszt);
    Player getLowBack3(String name1, String name2, String name3,String poszt);
    Player getLowBack5(String name1, String name2, String name3,String name4, String name5,String poszt);
    Player getStriker(String name1, String name2,String poszt);

}
