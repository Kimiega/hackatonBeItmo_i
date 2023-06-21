package space.arlet.meowhack.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import space.arlet.meowhack.data.EventInfo;
import space.arlet.meowhack.data.UserInfo;
import space.arlet.meowhack.repositories.EventRepo;
import space.arlet.meowhack.repositories.UserRepo;
import space.arlet.meowhack.services.UserNotFoundException;

import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void addUser(UserInfo userInfo) {
        userRepo.save(userInfo);
    }

    public void addUser(long userId, String name, long course) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(userId);
        userInfo.setName(name);
        userInfo.setCourse(course);
        addUser(userInfo);
    }

    public List<UserInfo> getUsers() {
        return userRepo.findAll();
    }

    public UserInfo getUserById(long userId) {
        return userRepo.findById(userId).orElseThrow(UserNotFoundException::new);
    }

}
