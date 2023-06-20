package space.arlet.meowhack.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.ZonedDateTime;

@Entity
@Table(name = "users_achievements")

public class UserAchievsInfo {
    @Id
    private long id;

    private long userId;

    private long achievId;

    private ZonedDateTime date;
}
