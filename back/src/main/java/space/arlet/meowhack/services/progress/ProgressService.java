package space.arlet.meowhack.services.progress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import space.arlet.meowhack.data.ProgressInfo;
import space.arlet.meowhack.repositories.ProgressRepo;
import space.arlet.meowhack.services.Direction;
import space.arlet.meowhack.services.UserNotFoundException;

@Service
public class ProgressService {
    public long[] tiers = {
            200, // common (по умолчанию берётся как граница для достижения первого уровня)
            550, // rare
            750, // epic
            1250 // legendary
    };

    private final long expStep = 50;

    private final ProgressRepo progressRepo;

    @Autowired
    public ProgressService(ProgressRepo progressRepo) {
        this.progressRepo = progressRepo;
    }

    public void updateProgress(long userId, ExperienceSource source) {
        ProgressInfo progressInfo = progressRepo.findById(userId).orElseThrow(UserNotFoundException::new);

        addExperience(progressInfo, source);
        recalculateLevels(progressInfo, source.getDirection());

        progressRepo.save(progressInfo);
    }

    private void recalculateLevels(ProgressInfo progressInfo, Direction direction) {
        long exp;
        long level;
        switch (direction) {
            case FRIENDLY -> {
                exp = progressInfo.getExpFriendly();
                level = progressInfo.getLvlFriendly();
            }
            case HEALTHY -> {
                exp = progressInfo.getExpHealthy();
                level = progressInfo.getLvlHealthy();
            }
            case PRO -> {
                exp = progressInfo.getExpPro();
                level = progressInfo.getLvlPro();
            }
            case FIT -> {
                exp = progressInfo.getExpFit();
                level = progressInfo.getLvlFit();
            }
            case ECO -> {
                exp = progressInfo.getExpEco();
                level = progressInfo.getLvlEco();
            }
            case OPEN -> {
                exp = progressInfo.getExpOpen();
                level = progressInfo.getLvlOpen();
            }
            default -> {
                exp = 0;
                level = 0;
            }
        }

        long newLevels = newLevelsCount(exp, level);

        if (newLevels != 0) {
            switch (direction) {
                case FRIENDLY -> progressInfo.setLvlFriendly(progressInfo.getLvlFriendly() + newLevels);
                case HEALTHY -> progressInfo.setLvlHealthy(progressInfo.getLvlHealthy() + newLevels);
                case PRO -> progressInfo.setLvlPro(progressInfo.getLvlPro() + newLevels);
                case FIT -> progressInfo.setLvlFit(progressInfo.getLvlFit() + newLevels);
                case ECO -> progressInfo.setLvlEco(progressInfo.getLvlEco() + newLevels);
                case OPEN -> progressInfo.setLvlOpen(progressInfo.getLvlOpen() + newLevels);
            }
            progressInfo.setLvl(progressInfo.getLvl() + newLevels);
        }
    }

    private void addExperience(ProgressInfo progressInfo, ExperienceSource source) {
        switch (source.getDirection()) {
            case ECO -> progressInfo.setExpEco(source.getExperience());
            case FIT -> progressInfo.setExpFit(source.getExperience());
            case PRO -> progressInfo.setExpPro(source.getExperience());
            case OPEN -> progressInfo.setExpOpen(source.getExperience());
            case HEALTHY -> progressInfo.setExpHealthy(source.getExperience());
            case FRIENDLY -> progressInfo.setExpFriendly(source.getExperience());
        }
    }

    private long newLevelsCount(long exp, long level) {
        long counter = 0;
        while (tiers[0] + (level + counter) * expStep >= exp) counter++;

        return counter;
    }
}
