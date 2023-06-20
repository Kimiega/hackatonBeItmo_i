package space.arlet.meowhack.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "achiev_codes")

public class AchievCode {
    @Id
    private long id;

    private String code;
    private long achievId;
}
