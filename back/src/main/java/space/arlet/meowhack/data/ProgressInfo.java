package space.arlet.meowhack.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user_progress")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProgressInfo {
    @Id
    private long userId;

    private long lvl;

    private long expEco;
    private long lvlEco;

    private long expFit;
    private long lvlFit;

    private long expFriendly;
    private long lvlFriendly;

    private long expHealthy;
    private long lvlHealthy;

    private long expOpen;
    private long lvlOpen;

    private long expPro;
    private long lvlPro;
}
