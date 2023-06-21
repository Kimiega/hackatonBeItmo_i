package space.arlet.meowhack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import space.arlet.meowhack.data.UserInfo;

public interface UserRepo extends JpaRepository<UserInfo, Long> {
}
