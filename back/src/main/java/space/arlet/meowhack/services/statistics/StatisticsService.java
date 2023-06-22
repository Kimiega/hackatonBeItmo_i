package space.arlet.meowhack.services.statistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import space.arlet.meowhack.data.UserInfo;
import space.arlet.meowhack.repositories.UserRepo;
import space.arlet.meowhack.services.achievements.AchievementsService;
import space.arlet.meowhack.services.achievements.checkers.AchievementsChecker;
import space.arlet.meowhack.services.achievements.checkers.Checker;
import space.arlet.meowhack.services.achievements.checkers.CheckerNotFoundException;
import space.arlet.meowhack.services.achievements.checkers.UserData;

import java.util.stream.Collectors;

@Service
public class StatisticsService {

    private final UserRepo userRepo;
    private final AchievementsService achievementsService;
    private final AchievementsChecker achievementsChecker;

    @Autowired
    StatisticsService(UserRepo userRepo, AchievementsService achievementsService) {
        this.userRepo = userRepo;
        this.achievementsService = achievementsService;
        this.achievementsChecker = new AchievementsChecker();
    }

    public void updateAchievements(long userId) {
        var userData = getUserData(userId);
        var achievements = achievementsService.getAllBuiltInAchievements();
        var userAchievements = achievementsService.getAllAchievementsByUserId(userId);

        achievements = achievements.stream().filter(element -> {
            for (var i : userAchievements) {
                if (i.getId() == element.getId())
                    return false;
            }
            return true;
        }).collect(Collectors.toList());

        for (var i : achievements) {
            var checker = findChecker(i.getId());

            if(checker.isReceived(userData))
                achievementsService.addAchievementsToUserById(userId, i.getId());
        }
    }

    private UserData getUserData(long userId) {
        var userData = new UserData();

        UserInfo userInfo = userRepo.getReferenceById(userId);

        userData.setUserId(userId);
        userData.setCourse(userInfo.getCourse());

        return userData;
    }

    private Checker findChecker(long achievementId) {
        return achievementsChecker.getCheckers().stream()
                .filter(element -> element.getId() == achievementId)
                .findAny()
                .orElseThrow(CheckerNotFoundException::new);
    }

}