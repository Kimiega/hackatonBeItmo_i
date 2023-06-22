package space.arlet.meowhack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import space.arlet.meowhack.data.UserInfo;
import space.arlet.meowhack.services.UserNotFoundException;
import space.arlet.meowhack.services.user.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "${api_path}/users")
public class UserController {
    private final UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ResponseEntity<Void> addUser(long userId, String name, long course) {
       userService.addUser(userId, name, course);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<UserInfo>> getUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<UserInfo> getUserById(long userId) {
        try {
            return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
