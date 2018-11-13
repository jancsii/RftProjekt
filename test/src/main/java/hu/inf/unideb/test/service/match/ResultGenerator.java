package hu.inf.unideb.test.service.match;

import hu.inf.unideb.test.entity.EnemyTeam;
import hu.inf.unideb.test.entity.MyTeam;
import static hu.inf.unideb.test.service.match.ResultGenerator.probalkozas;
import static hu.inf.unideb.test.service.match.ResultGenerator.szint;

import java.util.Random;

public class ResultGenerator {


    public MyTeam myTeam;
    public EnemyTeam enemyTeam;
    public int myTeamAllRang;
    public int myTeamAllErtek;
    public int enemyTeamAllRang;
    public int enemyTeamAllErtek;

    public static int getProbalkozas() {
        return probalkozas;
    }

    public void setProbalkozas(int probalkozas) {
            this.probalkozas = probalkozas;
    }
    public static int probalkozas=3;
    public static int szint=1;
    Random rand = new Random();
    int my_eredmeny=0;
    int enemy_eredmeny=0;
    public static boolean lose=false;
    public static boolean win=false;

    @Override
    public String toString() {
        return "myTeamAllRang= \n" + myTeamAllRang +
                ", myTeamAllErtek= " + myTeamAllErtek +
                ", enemyTeamAllRang= " + enemyTeamAllRang +
                ", enemyTeamAllErtek= " + enemyTeamAllErtek ;
    }

    public void setSzint(int szint) {
        this.szint = szint;
    }

    public MyTeam getMyTeam() {
        return myTeam;
    }

    public void setMyTeam(MyTeam myTeam) {
        this.myTeam = myTeam;
    }

    public ResultGenerator() {
    }

    public EnemyTeam getEnemyTeam() {
        return enemyTeam;
    }

    public void setEnemyTeam(EnemyTeam enemyTeam) {
        this.enemyTeam = enemyTeam;
    }

    public ResultGenerator(MyTeam myTeam, EnemyTeam enemyTeam) {
        this.myTeam = myTeam;
        this.enemyTeam = enemyTeam;
    }

    public int getMyTeamAllRang() {
        return myTeamAllRang;
    }

    public void setMyTeamAllRang(int myTeamAllRang) {
        this.myTeamAllRang = myTeamAllRang;
    }

    public int getMyTeamAllErtek() {
        return myTeamAllErtek;
    }

    public void setMyTeamAllErtek(int myTeamAllErtek) {
        this.myTeamAllErtek = myTeamAllErtek;
    }

    public int getEnemyTeamAllRang() {
        return enemyTeamAllRang;
    }

    public void setEnemyTeamAllRang(int enemyTeamAllRang) {
        this.enemyTeamAllRang = enemyTeamAllRang;
    }

    public int getEnemyTeamAllErtek() {
        return enemyTeamAllErtek;
    }

    public void setEnemyTeamAllErtek(int enemyTeamAllErtek) {
        this.enemyTeamAllErtek = enemyTeamAllErtek;
    }

    public void getResult(){

        double osszegrang=(getMyTeamAllRang()+getEnemyTeamAllRang())/2;
        double my_arany = getMyTeamAllRang()/osszegrang;
        double enemy_arany = getEnemyTeamAllRang()/osszegrang;
        double osszegertek=(getMyTeamAllErtek()+getEnemyTeamAllErtek())/2;
        double my_ertek_arany=getMyTeamAllErtek()/osszegertek;
        double enemy_ertek_arany=getEnemyTeamAllErtek()/osszegertek;


        int n=0;
        n = rand.nextInt(4)+1;

        if(my_arany>=enemy_arany && my_ertek_arany>=enemy_ertek_arany){
            my_eredmeny=n;
            int m= rand.nextInt(my_eredmeny)-1;
            if(m<0){
                enemy_eredmeny=0;
            }else{
                enemy_eredmeny=m;
            }
        }else if(my_arany>=enemy_arany && my_ertek_arany<enemy_ertek_arany ||
                my_arany>enemy_arany && my_ertek_arany<=enemy_ertek_arany){
            my_eredmeny=n;
            enemy_eredmeny=n-1;
            if(enemy_eredmeny<n-1){
                enemy_eredmeny=0;
            }
        }else if(my_arany<=enemy_arany && my_ertek_arany>enemy_ertek_arany ||
                my_arany<enemy_arany && my_ertek_arany>=enemy_ertek_arany){
            my_eredmeny=n;
            enemy_eredmeny=n;
        }else{
            enemy_eredmeny=n;
            int m=rand.nextInt(enemy_eredmeny)-1;
            if(m<0){
                my_eredmeny=0;
            }else{
                my_eredmeny=m;
            }
        }
    }
    public String eredmeny(){
        getResult();
        String eredmeny_szoveg;
            if(enemy_eredmeny>my_eredmeny){
            win=false;
            lose=true;
            enemyTeam.setProbalkozas(probalkozas);
            eredmeny_szoveg="A meccs eredménye: "+my_eredmeny + "-" + enemy_eredmeny;
        }else if(enemy_eredmeny==my_eredmeny){
            eredmeny_szoveg="A meccs eredménye: "+my_eredmeny + "-" + enemy_eredmeny;
            lose=false;
            win=false;
        }else{
            enemyTeam.setSzint(szint);
            win=true;
            lose=false;
            eredmeny_szoveg="A meccs eredménye: "+my_eredmeny + "-" + enemy_eredmeny;
        }
            return eredmeny_szoveg;
    }
}
