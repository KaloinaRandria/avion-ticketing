package mg.working.avionticketing.service.util;

import mg.working.avionticketing.entity.util.Ville;
import mg.working.avionticketing.repository.util.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VilleService {
    @Autowired
    VilleRepository villeRepository;

    public List<Ville> getAllVille() {
        return villeRepository.findAll();
    }

    public Ville getVilleById(int id) {
        return villeRepository.findById(id).orElse(null);
    }
}
