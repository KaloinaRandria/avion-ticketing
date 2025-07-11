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
    import org.springframework.web.bind.annotation.RequestParam;

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
                                @RequestParam(name = "avion") String idAvion,
                                @RequestParam(name = "villeDepart") String idVilleDepart,
                                @RequestParam(name = "villeArrivee") String idVilleArrivee,
                                @RequestParam(name = "dateDepart") String dateDepart,
                                @RequestParam(name = "dateArrivee") String dateArrivee,
                                @RequestParam(name = "prixBase") String prixBase) {
            Vol vol = new Vol();
            vol.setAvion(avionService.getAvionById(Integer.valueOf(idAvion)));
            vol.setVilleDepart(villeService.getVilleById(Integer.valueOf(idVilleDepart)));
            vol.setVilleArrivee(villeService.getVilleById(Integer.valueOf(idVilleArrivee)));
            vol.setDateDepart(dateDepart);
            vol.setDateArrivee(dateArrivee);
            vol.setPrixBase(prixBase);

            volService.insertVol(vol);

            return "redirect:/vol/list";
        }
    }
