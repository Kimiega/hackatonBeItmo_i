package space.arlet.meowhack.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import space.arlet.meowhack.services.Direction;
import space.arlet.meowhack.services.progress.ExperienceSource;
import space.arlet.meowhack.services.progress.ProgressService;

@Entity
@Table(name = "user_achievements")

@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter
public class Achiev implements ExperienceSource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String description;

    private int ownersCount;

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

    public class Builder {
        private final Achiev currentAchiev;

        Builder() {
            currentAchiev = new Achiev();
        }
        public Achiev build() {
            return currentAchiev;
        }

        public Builder setTitle(String value) {
            currentAchiev.setTitle(value);
            return this;
        }

        public Builder setDescription(String value) {
            currentAchiev.setDescription(value);
            return this;
        }

        public Builder setImageUrl(String value) {
            currentAchiev.setImageURL(value);
            return this;
        }

        public Builder setDirection(Direction value) {
            currentAchiev.setDirection(value);
            return this;
        }

        public Builder setExpByTier(ProgressService.Tier tier) {
            currentAchiev.setExp(tier.exp);
            return this;
        }
    }
}
