package space.arlet.meowhack.services.progress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import space.arlet.meowhack.data.ProgressInfo;
import space.arlet.meowhack.repositories.ProgressRepo;
import space.arlet.meowhack.services.Direction;
import space.arlet.meowhack.services.UserNotFoundException;

@Service
public class ProgressService {

    public enum Tier {
        COMMON(200),
        RARE(550),
        EPIC(750),
        LEGENDARY(1250);

        final long exp;

        Tier(long exp) {
            this.exp = exp;
        }
    }

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
        long exp = getExpByDirection(progressInfo, direction);
        long level = getLevelByDirection(progressInfo, direction);

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
        while (Tier.COMMON.exp + (level + counter) * expStep >= exp) counter++;

        return counter;
    }

    public ProgressInfo getProgressInfoByUserId(long userId) {
        return progressRepo.findById(userId).orElseThrow(UserNotFoundException::new);
    }

    public long getLevelByDirection(ProgressInfo progressInfo, Direction direction) {
        return switch (direction) {
            case FRIENDLY -> progressInfo.getLvlFriendly();
            case HEALTHY -> progressInfo.getLvlHealthy();
            case PRO -> progressInfo.getLvlPro();
            case FIT -> progressInfo.getLvlFit();
            case ECO -> progressInfo.getLvlEco();
            case OPEN -> progressInfo.getLvlOpen();
        };
    }

    public long getExpByDirection(ProgressInfo progressInfo, Direction direction) {
        return switch (direction) {
            case FRIENDLY -> progressInfo.getExpFriendly();
            case HEALTHY -> progressInfo.getExpHealthy();
            case PRO -> progressInfo.getExpPro();
            case FIT -> progressInfo.getExpFit();
            case ECO -> progressInfo.getExpEco();
            case OPEN -> progressInfo.getExpOpen();
        };
    }
}
