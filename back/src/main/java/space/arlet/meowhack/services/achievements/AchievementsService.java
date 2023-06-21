package space.arlet.meowhack.services.achievements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import space.arlet.meowhack.data.Achievement;
import space.arlet.meowhack.data.UserAchievementInfo;
import space.arlet.meowhack.repositories.AchievementsCodesRepo;
import space.arlet.meowhack.repositories.AchievementRepo;
import space.arlet.meowhack.repositories.UserAchievementsRepo;
import space.arlet.meowhack.services.progress.ProgressService;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class AchievementsService {

    private final AchievementRepo achievementRepo;
    private final ProgressService progressService;
    private final UserAchievementsRepo userAchievementsRepo;
    private final AchievementsCodesRepo achievementsCodesRepo;

    @Autowired
    AchievementsService(AchievementRepo achievementRepo,
                        ProgressService progressService,
                        UserAchievementsRepo userAchievementsRepo,
                        AchievementsCodesRepo achievementsCodesRepo) {
        this.achievementRepo = achievementRepo;
        this.progressService = progressService;
        this.userAchievementsRepo = userAchievementsRepo;
        this.achievementsCodesRepo = achievementsCodesRepo;
    }

    public void addAchievementsToUserById(long userId, long achievementId) {
        if (!achievementRepo.existsById(achievementId))
            throw new AchievementNotFoundException();

        var userAchievementsInfo = new UserAchievementInfo();

        userAchievementsInfo.setUserId(userId);
        userAchievementsInfo.setAchievementId(achievementId);
        userAchievementsInfo.setDate(ZonedDateTime.now());

        userAchievementsRepo.save(userAchievementsInfo);

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

    public List<UserAchievementInfo> getAllAchievementsByUserId(long userId) {
        return userAchievementsRepo.getUserAchievementInfosByUserId(userId);
    }

}
