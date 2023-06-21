package space.arlet.meowhack.services.achievements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import space.arlet.meowhack.data.Achievement;
import space.arlet.meowhack.data.UserAchievementInfo;
import space.arlet.meowhack.repositories.AchievementsCodesRepo;
import space.arlet.meowhack.repositories.AchievementRepo;
import space.arlet.meowhack.repositories.UserAchievsRepo;
import space.arlet.meowhack.services.progress.ProgressService;

import java.time.ZonedDateTime;

@Service
public class AchievementsService {

    private final AchievementRepo achievementRepo;
    private final ProgressService progressService;
    private final UserAchievsRepo userAchievsRepo;
    private final AchievementsCodesRepo achievementsCodesRepo;

    @Autowired
    AchievementsService(AchievementRepo achievementRepo,
                        ProgressService progressService,
                        UserAchievsRepo userAchievsRepo,
                        AchievementsCodesRepo achievementsCodesRepo) {
        this.achievementRepo = achievementRepo;
        this.progressService = progressService;
        this.userAchievsRepo = userAchievsRepo;
        this.achievementsCodesRepo = achievementsCodesRepo;
    }

    public void addAchievToUserById(long userId, long achievId) {
        if (!achievementRepo.existsById(achievId))
            throw new AchievementNotFoundException();

        var userAchievsInfo = new UserAchievementInfo();

        userAchievsInfo.setUserId(userId);
        userAchievsInfo.setAchievementId(achievId);
        userAchievsInfo.setDate(ZonedDateTime.now());

        userAchievsRepo.save(userAchievsInfo);

        Achievement achievement = achievementRepo.getReferenceById(achievId);

        achievement.setOwnersCount(achievement.getOwnersCount() + 1);
        progressService.updateProgress(userId, achievement);
    }

    public void addAchievToUserByCode(long userId, String code) {
        if (!achievementsCodesRepo.existsByCode(code))
            throw new AchievementCodeNotFoundException();

        long achievId = achievementsCodesRepo.getAchievCodeByCode(code).getAchievementId();

        addAchievToUserById(userId, achievId);
    }

    public void createAchiev(Achievement achievement) {
        if (achievementRepo.existsByTitle(achievement.getTitle()))
            throw new AchievementsExistsException();
        achievementRepo.save(achievement);
    }

}
