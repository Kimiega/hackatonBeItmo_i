package space.arlet.meowhack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import space.arlet.meowhack.data.EventInfo;
import space.arlet.meowhack.services.recommendation.RecommendationService;
import space.arlet.meowhack.services.UserNotFoundException;

import java.util.List;

@RestController
@RequestMapping(value = "${api_path}/recommendations")
public class RecommendationController {
    private final RecommendationService recommendationService;

    @Autowired
    RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<EventInfo>> getRecommendationList(long userId) {
        try {
            return new ResponseEntity<>(recommendationService.getRecommendationList(userId), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
