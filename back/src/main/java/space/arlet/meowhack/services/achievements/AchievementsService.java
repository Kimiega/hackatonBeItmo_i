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

    public void addAchievementsToUserById(long userId, long achievementId) {
        if (!achievementRepo.existsById(achievementId))
            throw new AchievementNotFoundException();

        var userAchievementsInfo = new UserAchievementInfo();

        userAchievementsInfo.setUserId(userId);
        userAchievementsInfo.setAchievementId(achievementId);
        userAchievementsInfo.setDate(ZonedDateTime.now());

        userAchievsRepo.save(userAchievementsInfo);

        Achievement achievement = achievementRepo.getReferenceById(achievementId);

        achievement.setOwnersCount(achievement.getOwnersCount() + 1);
        progressService.updateProgress(userId, achievement);
    }

    public void addAchievementToUserByCode(long userId, String code) {
        if (!achievementsCodesRepo.existsByCode(code))
            throw new AchievementCodeNotFoundException();

        long achievementId = achievementsCodesRepo.getAchievCodeByCode(code).getAchievementId();

        addAchievementsToUserById(userId, achievementId);
    }

    public void createAchievement(Achievement achievement) {
        if (achievementRepo.existsByTitle(achievement.getTitle()))
            throw new AchievementsExistsException();
        achievementRepo.save(achievement);
    }

}
