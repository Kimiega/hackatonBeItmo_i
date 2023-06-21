package space.arlet.meowhack.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import space.arlet.meowhack.services.Direction;
import space.arlet.meowhack.services.progress.ExperienceSource;

@Entity
@Table(name = "user_achievements")

@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter
public class Achiev implements ExperienceSource {
    @Id
    private long id;

    private String title;
    private String description;

    private float receivingPercent;

    private String imageURL;

    private long exp;

    private Direction direction;

    @Override
    public long getExperience() {
        return exp;
    }

    @Override
    public Direction getDirection() {
        return direction;
    }
}
