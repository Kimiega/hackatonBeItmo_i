package space.arlet.meowhack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import space.arlet.meowhack.data.TrafficInfo;
import space.arlet.meowhack.data.UserInfo;
import space.arlet.meowhack.services.UserNotFoundException;
import space.arlet.meowhack.services.traffic.TrafficService;
import space.arlet.meowhack.services.user.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "${api_path}/traffic")
public class TrafficController {
    private final TrafficService trafficService;

    @Autowired
    TrafficController(TrafficService trafficService) {
        this.trafficService = trafficService;
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> addUser(@RequestBody TrafficInfo trafficInfo) {
        trafficService.addTrafficInfo(trafficInfo);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
