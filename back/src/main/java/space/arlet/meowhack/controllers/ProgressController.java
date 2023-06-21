package space.arlet.meowhack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import space.arlet.meowhack.data.ProgressInfo;
import space.arlet.meowhack.services.UserNotFoundException;
import space.arlet.meowhack.services.progress.ProgressService;

@RestController
@RequestMapping(value = "${api_path}/progress")
public class ProgressController {

    private final ProgressService progressService;

    @Autowired
    ProgressController(ProgressService progressService) {
        this.progressService = progressService;
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ResponseEntity<ProgressInfo> getInfo(long userId) {
        //todo: проверка валидности userId
        return new ResponseEntity<>(progressService.getProgressInfoByUserId(userId), HttpStatus.OK);
    }
}
