package space.arlet.meowhack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import space.arlet.meowhack.data.UserAchievementInfo;
import space.arlet.meowhack.services.UserNotFoundException;
import space.arlet.meowhack.services.achievements.AchievementsService;

import java.util.List;

@RestController
@RequestMapping(value="${api_path}/achievements")
public class AchievementsController {

    private final AchievementsService achievementsService;

    @Autowired
    AchievementsController(AchievementsService achievementsService) {
        this.achievementsService = achievementsService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserAchievementInfo>> getAllAchievements(long userId) {
        return new ResponseEntity<>(achievementsService.getAllAchievementsByUserId(userId), HttpStatus.OK);
    }

}
