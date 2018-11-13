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
    public List<Integer> kapusok_ertek(List<Player> kapus);
    public List<Integer> kozep_ertek(List<Player> kozep);
    public List<Integer> vedo_ertek(List<Player> vedo);
    public List<Integer> tamado_ertek(List<Player> tamado);
    public List<Integer> kapusok_igazolas(List<Player> kapus);
    public List<Integer> kozep_igazolas(List<Player> kozep);
    public List<Integer> vedo_igazolas(List<Player> vedo);
    public List<Integer> tamado_igazolas(List<Player> tamado);
    public List<Integer> getKapus_ertek();
    public List<Integer> getVedo_ertek();
    public List<Integer> getKozep_ertek();
    public List<Integer> getTamado_ertek();
    public void setKapus_ertek(List<Integer> kapus_ertek);
    public void setVedo_ertek(List<Integer> vedo_ertek);
    public void setKozep_ertek(List<Integer> kozep_ertek);
    public void setTamado_ertek(List<Integer> tamado_ertek);
    
}
