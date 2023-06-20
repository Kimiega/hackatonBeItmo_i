package space.arlet.meowhack.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import space.arlet.meowhack.repositories.ProgressRepo;

@Service
public class ProgressService {
    private final ProgressRepo progressRepo;

    @Autowired
    public ProgressService(ProgressRepo progressRepo) {
        this.progressRepo = progressRepo;
    }

    public void updateProgress(ExperienceSource source) {

    }


}
