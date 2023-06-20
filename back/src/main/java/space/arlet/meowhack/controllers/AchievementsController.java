package space.arlet.meowhack.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="${api_path}/achieves")
public class AchievementsController {

    @RequestMapping(value="/test", method = RequestMethod.GET)
    public ResponseEntity<String> test(int a) {
        return new ResponseEntity<>((a+1)+"", HttpStatus.OK);
    }
}
