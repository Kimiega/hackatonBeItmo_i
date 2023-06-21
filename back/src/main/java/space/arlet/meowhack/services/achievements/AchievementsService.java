package space.arlet.meowhack.services.achievements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import space.arlet.meowhack.data.UserAchievsInfo;
import space.arlet.meowhack.repositories.AchievCodesRepo;
import space.arlet.meowhack.repositories.AchievRepo;
import space.arlet.meowhack.repositories.UserAchievsRepo;
import space.arlet.meowhack.services.progress.ProgressService;

import java.time.ZonedDateTime;

@Service
public class AchievementsService {

    private final AchievRepo achievRepo;
    private final ProgressService progressService;
    private final UserAchievsRepo userAchievsRepo;
    private final AchievCodesRepo achievCodesRepo;

    @Autowired
    AchievementsService(AchievRepo achievRepo,
                        ProgressService progressService,
                        UserAchievsRepo userAchievsRepo,
                        AchievCodesRepo achievCodesRepo) {
        this.achievRepo = achievRepo;
        this.progressService = progressService;
        this.userAchievsRepo = userAchievsRepo;
        this.achievCodesRepo = achievCodesRepo;
    }

    public void addAchievToUserById(long userId, long achievId) {
        if(!achievRepo.existsById(achievId))
            throw new AchievNotFoundException();

        var userAchievsInfo = new UserAchievsInfo();

        userAchievsInfo.setUserId(userId);
        userAchievsInfo.setAchievId(achievId);
        userAchievsInfo.setDate(ZonedDateTime.now());

        userAchievsRepo.save(userAchievsInfo);

        progressService.updateProgress(userId, achievRepo.getReferenceById(achievId));
    }

    public void addAchievToUserByCode(long userId, String code) {
        if (!achievCodesRepo.existsByCode(code))
            throw new CodeNotFoundException();

        long achievId = achievCodesRepo.getAchievCodeByCode(code).getAchievId();

        addAchievToUserById(userId, achievId);
    }

}
