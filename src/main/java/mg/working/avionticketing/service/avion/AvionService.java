package mg.working.avionticketing.service.avion;

import mg.working.avionticketing.entity.avion.Avion;
import mg.working.avionticketing.repository.avion.AvionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvionService {
    @Autowired
    AvionRepository avionRepository;

    public List<Avion> getAllAvion() {
        return avionRepository.findAll();
    }
}
