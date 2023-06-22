package space.arlet.meowhack.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "achiev_codes")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AchievementsCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String code;
    private long achievementId;
}
