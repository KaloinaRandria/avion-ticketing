package mg.working.avionticketing.controller;

import mg.working.avionticketing.entity.util.Vol;
import mg.working.avionticketing.service.util.VolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/vol")
public class VolController {
    @Autowired
    VolService volService;

    @GetMapping("/list")
    public String volList(Model model) {
        List<Vol> vols = volService.getAllVol();
        model.addAttribute("vols" , vols);
        return "vol/vol-list";
    }
}
