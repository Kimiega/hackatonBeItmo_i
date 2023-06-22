package space.arlet.meowhack.controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import space.arlet.meowhack.data.Achievement;
import space.arlet.meowhack.data.UserAchievementInfo;
import space.arlet.meowhack.services.Direction;
import space.arlet.meowhack.services.achievements.AchievementNotFoundException;
import space.arlet.meowhack.services.achievements.AchievementExistsException;
import space.arlet.meowhack.services.achievements.AchievementsService;
import space.arlet.meowhack.services.progress.ProgressService;
import space.arlet.meowhack.services.statistics.StatisticsService;

import java.util.List;

@RestController
public class AchievementsController {

    private final AchievementsService achievementsService;
    private final StatisticsService statisticsService;

    @Autowired
    AchievementsController(AchievementsService achievementsService, StatisticsService statisticsService) {
        this.achievementsService = achievementsService;
        this.statisticsService = statisticsService;
    }

    @RequestMapping(value="${api_path}/achievements", method = RequestMethod.GET)
    public ResponseEntity<List<UserAchievementInfo>> getAllAchievements(long userId) {
        statisticsService.updateAchievements(userId);
        return new ResponseEntity<>(achievementsService.getAllAchievementsByUserId(userId), HttpStatus.OK);
    }

    @RequestMapping(value = "${api_path}/achievement", method = RequestMethod.GET)
    public ResponseEntity<Achievement> getAchievement(long achievementId) {
        try {
            return new ResponseEntity<>(achievementsService.getAchievementById(achievementId), HttpStatus.OK);
        } catch (AchievementNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "${api_path}/achievement", method = RequestMethod.POST)
    public ResponseEntity<Void> addAchievement(@RequestBody AchievementRequestBody requestBody) {
        try {
            var builder = new Achievement.Builder();

            Achievement achievement = builder
                    .setExpByTier(requestBody.tier)
                    .setTitle(requestBody.title)
                    .setDescription(requestBody.description)
                    .setImageUrl(requestBody.imageURL)
                    .setDirection(requestBody.direction)
                    .build();

            achievementsService.createAchievement(achievement);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (AchievementExistsException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    private static class AchievementRequestBody {
        private String title;
        private String description;
        private String imageURL;
        private Direction direction;
        private ProgressService.Tier tier;
    }

}
