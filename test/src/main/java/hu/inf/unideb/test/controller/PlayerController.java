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
import static hu.inf.unideb.test.service.player.PlayerServiceImpl.enemy_team_igazolasertek;
import static hu.inf.unideb.test.service.player.PlayerServiceImpl.enemy_team_osszertek;
import static hu.inf.unideb.test.service.player.PlayerServiceImpl.kapus;
import static hu.inf.unideb.test.service.player.PlayerServiceImpl.my_team_igazolasertek;
import static hu.inf.unideb.test.service.player.PlayerServiceImpl.my_team_osszertek;
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
import java.util.Arrays;
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
    @RequestMapping(value = "/players", method = RequestMethod.GET)
    public ModelAndView getdata() {
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
        model.addObject("ertekek",resultGenerator.toString());
        
        return model;
    }
    @RequestMapping(value = "/players", method = RequestMethod.POST)
    public String vmi(){
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
            return "gyozelem";
        }
        if(enemyTeam.getProbalkozas()==0){
            resultGenerator.setSzint(1);
            resultGenerator.setProbalkozas(3);
            igazolt.clear();
            getMyTeam();
            getEnemyTeam();
            return "vereseg";
        }
        lose=false;
        win=false;
        getEnemyTeam();
        
        return "redirect:/players";
    } 
    
    @RequestMapping(value = "/myteam", method = RequestMethod.GET)
    public ModelAndView getmyteam() {
        ModelAndView model = new ModelAndView("myteam");
        model.addObject("listMyTeam", listMyTeam);
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
        List<String> kapus_kiir=playerService.kapusok(playerService.getNemhasznalt());        
        List<String> vedo_kiir=playerService.vedok(playerService.getNemhasznalt());        
        List<String> kozep_kiir=playerService.kozepek(playerService.getNemhasznalt());        
        List<String> tamado_kiir=playerService.tamadok(playerService.getNemhasznalt());
        kapus_kiir.removeAll(igazolt);
        vedo_kiir.removeAll(igazolt);
        kozep_kiir.removeAll(igazolt);
        tamado_kiir.removeAll(igazolt);
        
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
        Player kivalasztott_kapus=new Player();
        Player kivalasztott_vedok=new Player();
        Player kivalasztott_kozepek=new Player();
        Player kivalasztott_tamadok=new Player();
        kivalasztott_kapus.setNev(lekeresek_kapus);
        kivalasztott_vedok.setNev(lekeresek_vedok);
        kivalasztott_kozepek.setNev(lekeresek_kozepek);
        kivalasztott_tamadok.setNev(lekeresek_tamadok);
        
        for(int i=0;i<playerService.getNemhasznalt().size();i++){
            if(playerService.getNemhasznalt().get(i).getNev().equals(kivalasztott_kapus.getNev()) ||
                    playerService.getNemhasznalt().get(i).getNev().equals(kivalasztott_vedok.getNev()) || 
                    playerService.getNemhasznalt().get(i).getNev().equals(kivalasztott_kozepek.getNev()) || 
                    playerService.getNemhasznalt().get(i).getNev().equals(kivalasztott_tamadok.getNev())){
                    playerService.getNemhasznalt().remove(i);
                    igazolt.add(lekeresek_kapus);
                    igazolt.add(lekeresek_vedok);
                    igazolt.add(lekeresek_kozepek);
                    igazolt.add(lekeresek_tamadok);
            }
        }
        return "redirect:/piac";
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
        model.addAttribute("msg", "Jelentkezzen be!");
        return "login";
  }

  @RequestMapping(value = {"/","","/login"}, method = RequestMethod.POST)
  public String submit(Model model, @ModelAttribute("loginBean") LoginBean loginBean) {
        login_alany=userService.findByUsername(loginBean.getUserName());
        if(login_alany == null){
            model.addAttribute("error", "Nem ervenyes!");
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
        MyTeam myTeam = new MyTeam();
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
