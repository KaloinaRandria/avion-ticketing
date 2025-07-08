    package mg.working.avionticketing.controller;

    import mg.working.avionticketing.entity.util.Vol;
    import mg.working.avionticketing.service.avion.AvionService;
    import mg.working.avionticketing.service.util.VilleService;
    import mg.working.avionticketing.service.util.VolService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.boot.Banner;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestMapping;

    import java.util.List;

    @Controller
    @RequestMapping("/vol")
    public class VolController {
        @Autowired
        VolService volService;
        @Autowired
        AvionService avionService;
        @Autowired
        VilleService villeService;
        @GetMapping("/list")
        public String volList(Model model) {
            List<Vol> vols = volService.getAllVol();
            model.addAttribute("vols" , vols);
            return "vol/vol-list";
        }

        @GetMapping("/save-page")
        public String insertVolPage(Model model) {
            model.addAttribute("avions" , avionService.getAllAvion());
            model.addAttribute("villes" , villeService.getAllVille());
            model.addAttribute("vol", new Vol());
            return "vol/vol-insert";
        }

        @PostMapping("/save")
        public String insertVol(Model model ,
                                String idAvion,
                                String idVilleDepart,
                                String idVilleArrivee,
                                String dateDepart,
                                String dateArrivee,
                                String prixBase) {
            Vol vol = new Vol();


            return "redirect:/vol/list";
        }
    }
