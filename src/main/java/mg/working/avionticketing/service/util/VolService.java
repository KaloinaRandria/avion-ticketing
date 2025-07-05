package mg.working.avionticketing.service.util;

import mg.working.avionticketing.entity.util.Vol;
import mg.working.avionticketing.repository.util.VolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolService {
    @Autowired
    VolRepository volRepository;

    public void insertVol(Vol vol) {
        volRepository.save(vol);
    }

    public List<Vol> getAllVol() {
        return volRepository.findAll();
    }

    public Vol getVolById(int id) {
        return volRepository.findById(id).orElse(null);
    }

}
