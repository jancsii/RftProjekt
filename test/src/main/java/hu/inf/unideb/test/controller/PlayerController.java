package hu.inf.unideb.test.controller;

import hu.inf.unideb.test.service.user.UserService;
import hu.inf.unideb.test.service.team.TeamCreator;
import hu.inf.unideb.test.service.match.ResultGenerator;
import hu.inf.unideb.test.service.player.PlayerService;
import hu.inf.unideb.test.service.team.MyTeamService;
import hu.inf.unideb.test.service.team.EnemyTeamService;
import hu.inf.unideb.test.entity.LoginBean;
import hu.inf.unideb.test.entity.EnemyTeam;
import hu.inf.unideb.test.entity.MyTeam;
import hu.inf.unideb.test.entity.Player;
import hu.inf.unideb.test.entity.User;
import static hu.inf.unideb.test.service.match.ResultGenerator.lose;
import static hu.inf.unideb.test.service.match.ResultGenerator.win;
import static hu.inf.unideb.test.service.match.ResultGenerator.probalkozas;
import static hu.inf.unideb.test.service.match.ResultGenerator.szint;
import static hu.inf.unideb.test.service.player.PlayerServiceImpl.*;

import hu.inf.unideb.test.validator.UserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;

@Controller
public class PlayerController {

    final static Logger logger = LoggerFactory.getLogger(PlayerController.class);

    @Autowired
    TeamCreator teamCreator;
    @Autowired
    MyTeamService myTeamService;
    @Autowired
    EnemyTeamService enemyTeamService;
    @Autowired
    UserService userService;
    @Autowired
    PlayerService playerService;
    @Autowired
    UserValidator userValidator;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    
    
    MyTeam myTeam = new MyTeam();
    EnemyTeam enemyTeam=new EnemyTeam();
    public static User alany=new User();
    public static User alanyka=new User(); 
    public static User login_alany=new User();
    EnemyTeam ellenfel=new EnemyTeam();
    MyTeam sajat=new MyTeam();
    ResultGenerator resultGenerator = new ResultGenerator();
    public List<String> listMyTeam =new ArrayList();
    public List<String> listEnemyTeam = new ArrayList();
    public List<String> igazolt = new ArrayList();
    public List<Player> piac = new ArrayList<>();
    int kiirt_szint=0;
    
    @RequestMapping(value = "/players", method = RequestMethod.GET)
    public ModelAndView getdata() {
        torol();
        enemyTeamService.create(enemyTeam);
        lose=false;
        win=false;
        ModelAndView model = new ModelAndView("players");
        logger.info("Viewname {}",model.getViewName());
        model.addObject("listMyTeam", listMyTeam);
        model.addObject("listEnemyTeam", listEnemyTeam);
        model.addObject("szint","Jelenlegi szinted: "+enemyTeam.getSzint());
        model.addObject("probalkozas","Próbalkozasaid szama: "+enemyTeam.getProbalkozas());
        model.addObject("result",resultGenerator.eredmeny());
        if(win){
            model.addObject("res","Megnyerted a meccset!");
        }else if(lose){
            model.addObject("res","Elvesztetted a meccset!");
        }else{
            model.addObject("res","Döntetlen lett az eredmény!");
        }
        model.addObject("ertekek",resultGenerator.toString());
        
        return model;
    }

    @RequestMapping(value = "/players", method = RequestMethod.POST)
    public String vmi() {
        if(lose==true){
            --probalkozas;
            enemyTeam.setProbalkozas(probalkozas);
        }
        if(win==true){
            ++szint;
            enemyTeam.setSzint(szint);
        }
        if(enemyTeam.getSzint()>10){
            resultGenerator.setSzint(1);
            resultGenerator.setProbalkozas(3);
            igazolt.clear();
            getMyTeam();
            getEnemyTeam();
            piac=nemhasznalt;
            return "gyozelem";
        }
        if(enemyTeam.getProbalkozas()==0){
            resultGenerator.setSzint(1);
            resultGenerator.setProbalkozas(3);
            igazolt.clear();
            getMyTeam();
            getEnemyTeam();
            piac=nemhasznalt;
            return "redirect:/vereseg";
        }else{
        lose=false;
        win=false;
        getEnemyTeam();
        kiirt_szint=szint;
        return "redirect:/players";
        }
    }

    public void torol() {
        for (int i = 0; i < piac.size(); i++) {
            for (int j = 0; j < listEnemyTeam.size(); j++) {
                if (piac.get(i).getNev().equals(listEnemyTeam.get(j))) {
                    piac.remove(i);
                }
            }
        }
    }
    
    @RequestMapping(value = "/myteam", method = RequestMethod.GET)
    public ModelAndView getmyteam() {
        ModelAndView model = new ModelAndView("myteam");
        model.addObject("listMyTeam", listMyTeam);
        return model;
    }
     @RequestMapping(value = "/vereseg", method = RequestMethod.GET)
        public ModelAndView vereseg() {
            ModelAndView model = new ModelAndView("vereseg");
            model.addObject("elert", kiirt_szint-1);
            return model;
    }

       @RequestMapping(value = "/enemy", method = RequestMethod.GET)
    public ModelAndView getenemyteam() {
        ModelAndView model = new ModelAndView("enemy");
        model.addObject("listEnemyTeam", listEnemyTeam);
        return model;
    }
    
    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public ModelAndView get() {
        ModelAndView model = new ModelAndView("result");
        model.addObject("username", login_alany.getUsername());
        model.addObject("firstName", login_alany.getFirstName());
        model.addObject("lastName", login_alany.getLastName());
        model.addObject("email", login_alany.getEmail());
        return model;
    }
    
    @RequestMapping(value = "/piac", method = RequestMethod.GET)
    public ModelAndView getpiac() {
        List<Player> kapus_kiir=playerService.kapusok(piac);
        List<Player> vedo_kiir=playerService.vedok(piac);
        List<Player> kozep_kiir=playerService.kozepek(piac);
        List<Player> tamado_kiir=playerService.tamadok(piac);
        
        ModelAndView model = new ModelAndView("piac");
        model.addObject("kapus_kiir",kapus_kiir);
        model.addObject("vedo_kiir", vedo_kiir);
        model.addObject("kozep_kiir",kozep_kiir);
        model.addObject("tamado_kiir",tamado_kiir);

        return model;
    }
        
    @RequestMapping(value = "/piac", method = RequestMethod.POST)
    public String leker(HttpServletRequest request){

        String lekeresek_kapus=request.getParameter("selected");
        String lekeresek_vedok=request.getParameter("selected_vedok");
        String lekeresek_kozepek=request.getParameter("selected_kozepek");
        String lekeresek_tamadok=request.getParameter("selected_tamadok");
        MyTeam csapat=resultGenerator.myTeam;
        for(int s=0;s<piac.size();s++){
            Player player = new Player();
            int ertek = resultGenerator.getMyTeamAllErtek();
            int rang = resultGenerator.getMyTeamAllRang();
            if(piac.get(s).getNev().equals(lekeresek_kapus)){
                igazolt.add(lekeresek_kapus);
                player=playerService.getPlayerByName(resultGenerator.myTeam.getKapus(),"kapus");
                csapat.setKapus(lekeresek_kapus);
                myTeamService.create(csapat);
                logger.info("Kapus {}",player.getNev());
                resultGenerator.setMyTeamAllErtek(ertek - player.getErtek());
                resultGenerator.setMyTeamAllRang(rang- player.getRang());
                player= playerService.getPlayerByName(lekeresek_kapus,"kapus");
                resultGenerator.setMyTeamAllErtek(resultGenerator.getMyTeamAllErtek() + player.getErtek());
                resultGenerator.setMyTeamAllRang(resultGenerator.getEnemyTeamAllRang() + player.getRang());
                resultGenerator.getMyTeam().setKapus(lekeresek_kapus);
                listMyTeam = getList(resultGenerator.getMyTeam());
                piac.remove(player);               
            }else if(piac.get(s).getNev().equals(lekeresek_vedok)){
                igazolt.add(lekeresek_vedok);
                player=playerService.getLowBack(resultGenerator.getMyTeam().getVedoEgy(),resultGenerator.getMyTeam().getVedoKetto(),resultGenerator.getMyTeam().getVedoHarom(),resultGenerator.getMyTeam().getVedoNegy(),"vedo");
                if(resultGenerator.getMyTeam().getVedoEgy().equals(player.getNev())){
                    csapat.setVedoEgy(lekeresek_vedok);
                    myTeamService.create(csapat);
                }else if(resultGenerator.getMyTeam().getVedoKetto().equals(player.getNev())){
                    csapat.setVedoKetto(lekeresek_vedok);
                    myTeamService.create(csapat);
                }else if(resultGenerator.getMyTeam().getVedoHarom().equals(player.getNev())){
                    csapat.setVedoHarom(lekeresek_vedok);
                    myTeamService.create(csapat);
                }else if(resultGenerator.getMyTeam().getVedoNegy().equals(player.getNev())){
                    csapat.setVedoNegy(lekeresek_vedok);
                    myTeamService.create(csapat);
                }
                logger.info("Név:{} Érték: {}",player.getNev(),player.getRang());
                resultGenerator.setMyTeamAllErtek(resultGenerator.getMyTeamAllErtek() - player.getErtek());
                resultGenerator.setMyTeamAllRang(resultGenerator.getEnemyTeamAllRang() - player.getRang());
                nevez_vedo(player.getNev(),lekeresek_vedok);
                player = playerService.getPlayerByName(lekeresek_vedok,"vedo");
                resultGenerator.setMyTeamAllErtek(resultGenerator.getMyTeamAllErtek() + player.getErtek());
                resultGenerator.setMyTeamAllRang(resultGenerator.getEnemyTeamAllRang() + player.getRang());
                piac.remove(player);
            }else if(piac.get(s).getNev().equals(lekeresek_kozepek)){
                igazolt.add(lekeresek_kozepek);
                player=playerService.getLowBack(resultGenerator.getMyTeam().getKozepEgy(),resultGenerator.getMyTeam().getKozepKetto(),resultGenerator.getMyTeam().getKozepHarom(),resultGenerator.getMyTeam().getKozepNegy(),"kozeppalyas");
                if(resultGenerator.getMyTeam().getKozepEgy().equals(player.getNev())){
                    csapat.setKozepEgy(lekeresek_kozepek);
                    myTeamService.create(csapat);
                }else if(resultGenerator.getMyTeam().getKozepKetto().equals(player.getNev())){
                    csapat.setKozepKetto(lekeresek_kozepek);
                    myTeamService.create(csapat);
                }else if(resultGenerator.getMyTeam().getKozepHarom().equals(player.getNev())){
                    csapat.setKozepHarom(lekeresek_kozepek);
                    myTeamService.create(csapat);
                }else if(resultGenerator.getMyTeam().getKozepNegy().equals(player.getNev())){
                    csapat.setKozepNegy(lekeresek_kozepek);
                    myTeamService.create(csapat);
                }
                logger.info("Név:{} Érték: {}",player.getNev(),player.getRang());
                resultGenerator.setMyTeamAllErtek(resultGenerator.getMyTeamAllErtek() - player.getErtek());
                resultGenerator.setMyTeamAllRang(resultGenerator.getEnemyTeamAllRang() - player.getRang());
                nevez_kozep(player.getNev(),lekeresek_kozepek);
                player = playerService.getPlayerByName(lekeresek_kozepek,"kozeppalyas");
                resultGenerator.setMyTeamAllErtek(resultGenerator.getMyTeamAllErtek() + player.getErtek());
                resultGenerator.setMyTeamAllRang(resultGenerator.getEnemyTeamAllRang() + player.getRang());
                piac.remove(player);
            }else if(piac.get(s).getNev().equals(lekeresek_tamadok)){
                igazolt.add(lekeresek_tamadok);
                System.out.println(lekeresek_tamadok);
                player=playerService.getStriker(resultGenerator.getMyTeam().getTamadoEgy(),resultGenerator.getMyTeam().getTamadoKetto(),"tamado");
                if(resultGenerator.getMyTeam().getTamadoEgy().equals(player.getNev())){
                    csapat.setTamadoEgy(lekeresek_tamadok);
                    myTeamService.create(csapat);
                }else if(resultGenerator.getMyTeam().getTamadoKetto().equals(player.getNev())){
                    csapat.setTamadoKetto(lekeresek_tamadok);
                    myTeamService.create(csapat);
                }
                logger.info("Név:{} Érték: {}",player.getNev(),player.getRang());
                resultGenerator.setMyTeamAllErtek(resultGenerator.getMyTeamAllErtek() - player.getErtek());
                resultGenerator.setMyTeamAllRang(resultGenerator.getEnemyTeamAllRang() - player.getRang());
                nevez_tamado(player.getNev(),lekeresek_tamadok);
                player = playerService.getPlayerByName(lekeresek_tamadok,"tamado");
                resultGenerator.setMyTeamAllErtek(resultGenerator.getMyTeamAllErtek() + player.getErtek());
                resultGenerator.setMyTeamAllRang(resultGenerator.getEnemyTeamAllRang() + player.getRang());
                piac.remove(player);
            }
        }
        return "redirect:/piac";
    }

    public void nevez_vedo (String regi_nev, String uj_nev){
        if(resultGenerator.getMyTeam().getVedoEgy().equals(regi_nev)){
            resultGenerator.getMyTeam().setVedoEgy(uj_nev);
        }else if(resultGenerator.getMyTeam().getVedoKetto().equals(regi_nev)){
            resultGenerator.getMyTeam().setVedoKetto(uj_nev);
        }else if(resultGenerator.getMyTeam().getVedoHarom().equals(regi_nev)){
            resultGenerator.getMyTeam().setVedoHarom(uj_nev);
        }else if(resultGenerator.getMyTeam().getVedoNegy().equals(regi_nev)){
            resultGenerator.getMyTeam().setVedoNegy(uj_nev);
        }
        listMyTeam = getList(resultGenerator.getMyTeam());
    }


    public void nevez_kozep (String regi_nev, String uj_nev){
        if(resultGenerator.getMyTeam().getKozepEgy().equals(regi_nev)){
            resultGenerator.getMyTeam().setKozepEgy(uj_nev);
        }else if(resultGenerator.getMyTeam().getKozepKetto().equals(regi_nev)){
            resultGenerator.getMyTeam().setKozepKetto(uj_nev);
        }else if(resultGenerator.getMyTeam().getKozepHarom().equals(regi_nev)){
            resultGenerator.getMyTeam().setKozepHarom(uj_nev);
        }else if(resultGenerator.getMyTeam().getKozepNegy().equals(regi_nev)){
            resultGenerator.getMyTeam().setKozepNegy(uj_nev);
        }
        listMyTeam = getList(resultGenerator.getMyTeam());
    }
    public void nevez_tamado (String regi_nev, String uj_nev) {
        if (resultGenerator.getMyTeam().getTamadoEgy().equals(regi_nev)) {
            resultGenerator.getMyTeam().setTamadoEgy(uj_nev);
        } else if (resultGenerator.getMyTeam().getTamadoKetto().equals(regi_nev)) {
            resultGenerator.getMyTeam().setTamadoKetto(uj_nev);
        }
        listMyTeam = getList(resultGenerator.getMyTeam());
    }
  @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration() {
        return new ModelAndView("registration", "userReg", new User());
    }
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String reg(@ModelAttribute("userReg") User user,BindingResult bindingResult,ModelMap model) {
        userValidator.validate(user,bindingResult);
        
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        
        userService.save(user);
        alany.setUsername(user.getUsername());
        alany.setPassword(user.getPassword());
        alany.setConfirmPassword(user.getConfirmPassword());
        alany.setFirstName(user.getFirstName());
        alany.setLastName(user.getLastName());
        alany.setEmail(user.getEmail());
        alany.setId(user.getId());
        return "redirect:/login";
    }
    
@RequestMapping(value = {"/","","/login"}, method = RequestMethod.GET)
    public String init(Model model) {
        return "login";
  }

  @RequestMapping(value = {"/","","/login"}, method = RequestMethod.POST)
  public String submit(Model model, @ModelAttribute("loginBean") LoginBean loginBean) {
        login_alany=userService.findByUsername(loginBean.getUserName());
        if(login_alany == null){
            model.addAttribute("error", "Nincs ilyen felhasználó!");
            return "login";            
        }else{ 
            if(loginBean.getPassword() != null) {
                if(login_alany.getUsername().equals(loginBean.getUserName()) && bCryptPasswordEncoder.matches(loginBean.getPassword(), login_alany.getPassword())){
                            model.addAttribute("username", login_alany.getUsername());
                            model.addAttribute("firstName", login_alany.getFirstName());
                            model.addAttribute("lastName", login_alany.getLastName());
                            model.addAttribute("email", login_alany.getEmail());
                            alanyka.setId(login_alany.getId());
                            getMyTeam();
                            getEnemyTeam();
                            piac=nemhasznalt;
                return "result";
                }else {
                    model.addAttribute("error", "Bejelentkezés sikertelen!");
                return "login";
                }
            }else{
                System.out.println("Nincs megadva jelszó!");
                return "login";}
     }
}

  
    public void getMyTeam()
    {
        
        myTeam = teamCreator.createMyTeam(myTeam,80,85);
        logger.info("Saját csapat legenerálva!");
        resultGenerator.setMyTeamAllErtek(my_team_igazolasertek);
        resultGenerator.setMyTeamAllRang(my_team_osszertek);
        sajat=myTeam;
        resultGenerator.setMyTeam(sajat);
        myTeamService.create(myTeam);
        listMyTeam = getList(sajat);

    }

    public void getEnemyTeam()
    {
        int szint = enemyTeam.getSzint() * (3/2);
        enemyTeam=teamCreator.createEnemyTeam(enemyTeam, 75 + szint, 85 + szint);
        //enemyTeam=teamCreator.createEnemyTeam(enemyTeam, 70, 85);
        resultGenerator.setEnemyTeamAllErtek(enemy_team_igazolasertek);
        resultGenerator.setEnemyTeamAllRang(enemy_team_osszertek);
        logger.info("Ellenfél csapat legenerálva!");
        ellenfel=enemyTeam;
        resultGenerator.setEnemyTeam(ellenfel);
        listEnemyTeam = getListEnemy(ellenfel);
        
    }

    private List<String> getList(MyTeam myTeam) {
        List<String> list = new ArrayList<String>();
        list.add(myTeam.getKapus());
        list.add(myTeam.getVedoEgy());
        list.add(myTeam.getVedoKetto());
        list.add(myTeam.getVedoHarom());
        list.add(myTeam.getVedoNegy());
        list.add(myTeam.getKozepEgy());
        list.add(myTeam.getKozepKetto());
        list.add(myTeam.getKozepHarom());
        list.add(myTeam.getKozepNegy());
        list.add(myTeam.getTamadoEgy());
        list.add(myTeam.getTamadoKetto());
        return list;

    }

    private List<String> getListEnemy(EnemyTeam myTeam) {
       List<String> list = new ArrayList<String>();
        list.add(myTeam.getKapus());
        list.add(myTeam.getVedoEgy());
        list.add(myTeam.getVedoKetto());
        list.add(myTeam.getVedoHarom());
        list.add(myTeam.getVedoNegy());
        list.add(myTeam.getKozepEgy());
        list.add(myTeam.getKozepKetto());
        list.add(myTeam.getKozepHarom());
        list.add(myTeam.getKozepNegy());
        list.add(myTeam.getTamadoEgy());
        list.add(myTeam.getTamadoKetto());
        return list;
    }
}
